package org.rm.genie.vaapp.component.rm.NewComp2.client;

import org.rm.genie.vaapp.component.rm.NewComp2.QqqWww;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

/**
 * Created by vstebakov on 26.11.2015.
 */
@Connect(QqqWww.class)
public class QqqWwwConnector extends AbstractComponentConnector
{
  private final QqqWwwServerRpc serverRpc = RpcProxy.create(QqqWwwServerRpc.class, this);

  public QqqWwwConnector()
  {
    registerRpc(QqqWwwClientRpc.class, new QqqWwwClientRpc()
    {
    });
  }

  @Override
  protected Widget createWidget()
  {
    return GWT.create(QqqWwwWidget.class);
  }

  @Override
  public QqqWwwWidget getWidget()
  {
    return (QqqWwwWidget) super.getWidget();
  }

  @Override
  public QqqWwwState getState()
  {
    return (QqqWwwState) super.getState();
  }
}
