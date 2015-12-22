package org.rm.genie.vaapp.component.rm.NewComp2;

import org.rm.genie.vaapp.component.rm.NewComp2.client.QqqWwwClientRpc;
import org.rm.genie.vaapp.component.rm.NewComp2.client.QqqWwwServerRpc;
import org.rm.genie.vaapp.component.rm.NewComp2.client.QqqWwwState;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.ui.AbstractComponent;

/**
 * Created by vstebakov on 26.11.2015.
 */
public class QqqWww extends AbstractComponent
{
  public QqqWww()
  {
    registerRpc(new QqqWwwServerRpc()
    {
      private QqqWwwClientRpc getClientRpc()
      {
        return getRpcProxy(QqqWwwClientRpc.class);
      }
    });
  }

  @Override
  protected QqqWwwState getState()
  {
    return (QqqWwwState) super.getState();
  }
}
