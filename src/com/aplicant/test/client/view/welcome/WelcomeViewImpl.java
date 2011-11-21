/**
 * 
 */
package com.aplicant.test.client.view.welcome;

import com.aplicant.test.client.presenter.welcome.WelcomePresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author dOkI
 *
 */
public class WelcomeViewImpl extends Composite implements WelcomeView {
	
	private WelcomePresenter presenter;
	
	private static WelcomeViewImplUiBinder uiBinder = GWT
			.create(WelcomeViewImplUiBinder.class);

	interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public WelcomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Button button;
	@UiField InlineLabel GreetingsLabel;

	@UiHandler("button")
	void onClick(ClickEvent e) {
		//Window.alert("goto phonebook");
		
		presenter.gotoPhonebook();
	}

	@Override
	public Widget asWidget(){
		return this;
	}

	@Override
	public void setPresenter(Object presenter) {
		this.presenter = (WelcomePresenter) presenter;
	}

}
