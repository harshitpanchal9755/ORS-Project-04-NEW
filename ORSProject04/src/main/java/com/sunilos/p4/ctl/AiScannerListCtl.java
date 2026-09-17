package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.AiScannerBean;
import com.sunilos.p4.model.AiScannerModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/AiScannerListCtl")
public class AiScannerListCtl extends BaseListCtl<AiScannerBean, AiScannerModel>{

	@Override
	protected String getView() {
		return ORSView.AISCANNER_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.AISCANNER_LIST_VIEW;
	}

	@Override
	protected AiScannerModel getModel() {
		// TODO Auto-generated method stub
		return new AiScannerModel();
	}

}
