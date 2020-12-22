package com.azeus.exam.support;

import java.io.IOException;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.springframework.stereotype.Service;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKExceptionBase;

/**
 *
 * @author Administrator
 */
@Service
public class TestPrint {

	public static void main(String[] args) throws IOException {
		String document = "DO0101180622000010";
		// printBill(document);
		//prinSignOff("120", "2018-11-22");
		System.out.println("here");

	}

	public static void reprintBill(String document) throws IOException {
		String docnum = document;

		String reportName = "reports/opbillreprint.rpt";
		// String EXPORT_FILE = "h:\\new.pdf";

		ReportClientDocument clientDoc = null;

		try {
			if (clientDoc == null) {

				clientDoc = new ReportClientDocument();
				clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);

				// Open report
				// close for checking
				clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);

				// ****** BEGIN SET RUNTIME DATABASE CREDENTIALS ****************
				{
					ZabCRViewer.changeDataSource(clientDoc);

					// logon to database
					ZabCRViewer.logonDataSource(clientDoc);
				}
				{
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "zid", 100080);
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "dornum", docnum);
					PrintService service = PrintServiceLookup.lookupDefaultPrintService();
					ZabCRViewer.printToServer(clientDoc, service.getName());
					ZabCRViewer.exportPDF(clientDoc, true);
				}
			}

		} catch (ReportSDKExceptionBase e) {
			e.printStackTrace();
		}

	}

	public static void printBill(String document) throws IOException {
		String docnum = document;

		String reportName = "reports/opbill.rpt";
		// String EXPORT_FILE = "h:\\new.pdf";

		ReportClientDocument clientDoc = null;

		try {
			if (clientDoc == null) {

				clientDoc = new ReportClientDocument();
				clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);

				// Open report
				// close for checking
				clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);

				// ****** BEGIN SET RUNTIME DATABASE CREDENTIALS ****************
				{
					ZabCRViewer.changeDataSource(clientDoc);

					// logon to database
					ZabCRViewer.logonDataSource(clientDoc);
				}
				{
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "zid", 100080);
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "dornum", docnum);
					PrintService service = PrintServiceLookup.lookupDefaultPrintService();
					ZabCRViewer.printToServer(clientDoc, service.getName());
					ZabCRViewer.exportPDF(clientDoc, true);
				}
			}

		} catch (ReportSDKExceptionBase e) {
			e.printStackTrace();
		}

	}

	public static void prinSignOff(String terminal, String date) throws IOException {

		String reportName = "reports/opposmngsingoff.rpt";
		// String EXPORT_FILE = "h:\\new.pdf";

		ReportClientDocument clientDoc = null;

		try {
			if (clientDoc == null) {

				clientDoc = new ReportClientDocument();
				clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);

				// Open report
				// close for checking
				clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);

				// ****** BEGIN SET RUNTIME DATABASE CREDENTIALS ****************
				{
					ZabCRViewer.changeDataSource(clientDoc);

					// logon to database
					ZabCRViewer.logonDataSource(clientDoc);
				}
				{
					// System.out.println(terminal);
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "@zid", 100080);
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "@terminal", terminal);
					ZabCRViewer.addDiscreteParameterValue(clientDoc, "", "@date", date);
					PrintService service = PrintServiceLookup.lookupDefaultPrintService();
					ZabCRViewer.printToServer(clientDoc, service.getName());
					ZabCRViewer.exportPDF(clientDoc, true);
				}
			}

		} catch (ReportSDKExceptionBase e) {
			e.printStackTrace();
		}

	}
}
