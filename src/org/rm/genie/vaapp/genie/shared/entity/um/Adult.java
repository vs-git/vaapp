package org.rm.genie.vaapp.genie.shared.entity.um;

import org.rm.genie.vaapp.genie.shared.constant.ProductTypes;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ssokolov on 04.08.2015.
 */
public class Adult extends User
{
  public List<Integer> productTypes;

  public boolean isAvailableProductType(int productType)
  {
    return productTypes.contains(productType);
  }

  public Integer[] getProductTypesForSystem(boolean isExperimental)
  {
    List<Integer> result = new ArrayList<>();
    for (int productType : productTypes)
      if (isExperimental == ProductTypes.isG3(productType)) result.add(productType);

    return result.toArray(new Integer[result.size()]);
  }

  @Override
  public String toString()
  {
    return "User{" +
      "ID=" + userID +
      ", login=" + loginName +
      ", roleId=" + roleId +
      ", md5hash=" + md5hash +
      ", firstName=" + firstName +
      ", middleInitial=" + middleInitial +
      ", lastName=" + lastName +
      ", nickName=" + nickName +
      ", prefix=" + prefix +
      ", description=" + description +
      ", active=" + active +
      ", timeZone=" + timeZone +
      ", isGuest=" + isGuest +
      ", system=" + system +
      ", staar=" + isStaar() +
      ", sbrc=" + isSbrc() +
      ", testContentCatalog=" + getTestContentCatalog() +
      ", idNumber=" + idNumber +
      ", email=" + email +
      ", debug=" + debug +
      ", access=" + isRealClassesAccessible() +
      ", demo=" + isDemo +
      ", sse=" + isSse() +
      ", isIndividual=" + isIndividual() +
      ", productTypes=" + productTypes +
      '}';
  }
}
