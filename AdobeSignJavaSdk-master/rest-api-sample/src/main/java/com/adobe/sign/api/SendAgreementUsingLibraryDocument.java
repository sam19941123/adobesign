/*
*  Copyright 2016 Adobe Systems Incorporated. All rights reserved.
*  This file is licensed to you under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License. You may obtain a copy
*  of the License at http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under
*  the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
*  OF ANY KIND, either express or implied. See the License for the specific language
*  governing permissions and limitations under the License.
*
*/

package com.adobe.sign.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import com.adobe.sign.model.agreements.AgreementCreationResponse;
import com.adobe.sign.model.agreements.AgreementInfo;
import com.adobe.sign.utils.AgreementUtils;
import com.adobe.sign.utils.Constants;
import com.adobe.sign.utils.Errors;
import com.adobe.sign.utils.LibraryDocumentUtils;
import com.adobe.sign.utils.ApiUtils;
import com.adobe.sign.utils.ApiException;

import java.io.*;
import java.io.File;

import com.adobe.sign.api.TransientDocumentsApi;
import com.adobe.sign.model.transientDocuments.TransientDocumentResponse;




/**
 * This sample client demonstrates how to send a new agreement.
 *
 * <p>
 * Following workflow has been implemented here :
 * <li> Get the id of the first library document of the user</li>
 * <li> Get agreement info and create an agreement using the library document.</li>
 * <li> Send the agreement.</li>
 * <li> Display agreement details.</li>
 * <b>IMPORTANT</b>: Before running this sample, check that you have modified the 'Constants.java' file with appropriate access token value.
 * </p>
 */

public class SendAgreementUsingLibraryDocument {

  /**
   * Entry point for this sample client program.
   */
  public static void main(String args[]) throws ApiException, IOException {
    ApiUtils.configureProperty(SendAgreementUsingLibraryDocument.class.getName());
    try {
      SendAgreementUsingLibraryDocument client = new SendAgreementUsingLibraryDocument();
      //client.readmail();
      client.run();
    }
    catch (ApiException e) {
      ApiUtils.logException(Errors.SEND_AGREEMENT_USING_LIBRARY_DOCUMENT, e);
      throw e;
    }
  }
  
  /**
   * Main work function. See the class comment for details.
   */
  private final static TransientDocumentsApi transientDocumentsApi = new TransientDocumentsApi();
  private void run() throws ApiException, IOException {
    //Get the id of the first library document of the user.
    


    String libraryDocumentId = LibraryDocumentUtils.getFirstLibraryDocumentId();



    /*MultivaluedMap headers = new MultivaluedMapImpl();    
    //Add headers    
    headers.put("Access-Token", Constants.ACCESS_TOKEN);    
    headers.put("x-api-user", Constants.X_API_USER);
    
    File uploadfile = new File("test.pdf");
    TransientDocumentResponse  transientDocumentResponse = transientDocumentsApi.createTransientDocument(headers, "test.pdf", uploadfile.getAbsoluteFile(), "application/pdf");
    String libraryDocumentId = transientDocumentResponse.getTransientDocumentId();
    System.out.println("111111111"+libraryDocumentId);
*/
    if(libraryDocumentId == null) {
      ApiUtils.logError(Errors.NO_LIBRARY_DOCUMENTS);
    }
    else {
      //List containing email ids of recipients
      List<String> recipientSetEmailList = new ArrayList<String>();
      //recipientSetEmailList.add(ApiUtils.getUserEmail(Constants.USER_EMAIL_PREFIX,Constants.USER_EMAIL_DOMAIN));

    
      
      FileReader fr = new FileReader("mail.txt");
    

    BufferedReader br = new BufferedReader(fr);
    try{
      while (br.ready()) {
        recipientSetEmailList.add(br.readLine());
        //System.out.println(br.readLine());
      }
      fr.close();
    }
    catch(IOException e){

    }
    
      
      //recipientSetEmailList.add("sam_huang@i-planet.com.tw");
      //Create agreement using the first library document of the user
      AgreementCreationResponse agreementCreationResponse = AgreementUtils.createAgreement(recipientSetEmailList,
                                                                                           libraryDocumentId,
                                                                                           AgreementUtils.DocumentIdentifierType.LIBRARY_DOCUMENT_ID,
                                                                                           ApiUtils.getAgreementName(Constants.AGREEMENT_NAME));
      //System.out.println(Constants.AGREEMENT_NAME);
      //Get agreement info using the agreement id
      AgreementInfo agreementInfo = AgreementUtils.getAgreementInfo(agreementCreationResponse.getAgreementId());

      //Display agreement details
      ApiUtils.getLogger().info("Agreement ID = " + agreementInfo.getAgreementId());
      ApiUtils.getLogger().info("Agreement Name = " + agreementInfo.getName());
      ApiUtils.getLogger().info("Agreement Status = " + agreementInfo.getStatus());
    }
  }
}

