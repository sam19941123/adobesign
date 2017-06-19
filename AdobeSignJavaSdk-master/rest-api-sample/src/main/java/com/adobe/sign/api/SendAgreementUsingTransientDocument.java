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

import com.adobe.sign.model.agreements.AgreementCreationResponse;
import com.adobe.sign.model.agreements.AgreementInfo;
import com.adobe.sign.model.transientDocuments.TransientDocumentResponse;
import com.adobe.sign.utils.AgreementUtils;
import com.adobe.sign.utils.Constants;
import com.adobe.sign.utils.Errors;
import com.adobe.sign.utils.TransientDocumentUtils;
import com.adobe.sign.utils.ApiUtils;
import com.adobe.sign.utils.ApiException;

import java.io.*;

/**
 * This sample client demonstrates how to send a new agreement.
 *
 * <p>
 * Following workflow has been implemented here :
 * <li> Create a transient document and get transient document id.</li>
 * <li> Get agreement info and create an agreement using the transient document.</li>
 * <li> Send the agreement.</li>
 * <li> Display agreement details.</li>
 * <b>IMPORTANT</b>: Before running this sample, check that you have modified the 'Constants.java' file with appropriate values.
 * </p>
 */

public class SendAgreementUsingTransientDocument {

  /**
   * Entry point for this sample client program.
   */
  public static void main(String args[]) throws ApiException, IOException{
    ApiUtils.configureProperty(SendAgreementUsingTransientDocument.class.getName());
    try {
      SendAgreementUsingTransientDocument client = new SendAgreementUsingTransientDocument();
      client.run();
    }
    catch (ApiException e) {
      ApiUtils.logException(Errors.SEND_AGREEMENT_USING_TRANSIENT_DOCUMENT, e);
      throw e;
    }
  }

  /**
   * Main work function. See the class comment for details.
   */
  private void run() throws ApiException, IOException{
    //Create transient document.
    TransientDocumentResponse transientDocumentResponse = TransientDocumentUtils.createTransientDocument(Constants.REQUEST_PATH,
                                                                                                         Constants.INPUT_FILE_NAME);

    //Get the id of the transient document.
    String transientDocumentId = transientDocumentResponse.getTransientDocumentId();

    //List containing email ids of recipients.
    List<String> recipientSetEmailList = new ArrayList<String>();
    //recipientSetEmailList.add(ApiUtils.getUserEmail(Constants.USER_EMAIL_PREFIX,Constants.USER_EMAIL_DOMAIN));
    FileReader fr = new FileReader("gary/mail3.txt");
    

    BufferedReader br = new BufferedReader(fr);
    //
    try{
      while (br.ready()) {
        String b;
        int j = 0;
        String a = br.readLine();

        if(!a.trim().equals("")){
          
            //System.out.println("zzzzzzzzz\n");
            //if((Character.isLetter(a.charAt(0)))== 0){
            if(a.charAt(0)!='a'&&a.charAt(0)!='b'&&a.charAt(0)!='c'&&a.charAt(0)!='d'&&a.charAt(0)!='e'&&a.charAt(0)!='f'&&a.charAt(0)!='g'&&a.charAt(0)!='h'&&a.charAt(0)!='i'&&a.charAt(0)!='j'&&a.charAt(0)!='k'&&a.charAt(0)!='l'&&a.charAt(0)!='m'&&a.charAt(0)!='n'&&a.charAt(0)!='o'&&a.charAt(0)!='p'&&a.charAt(0)!='q'&&a.charAt(0)!='r'&&a.charAt(0)!='s'&&a.charAt(0)!='t'&&a.charAt(0)!='u'&&a.charAt(0)!='v'&&a.charAt(0)!='w'&&a.charAt(0)!='x'&&a.charAt(0)!='y'&&a.charAt(0)!='z'&&
              a.charAt(0)!='A'&&a.charAt(0)!='B'&&a.charAt(0)!='C'&&a.charAt(0)!='D'&&a.charAt(0)!='E'&&a.charAt(0)!='F'&&a.charAt(0)!='G'&&a.charAt(0)!='H'&&a.charAt(0)!='I'&&a.charAt(0)!='J'&&a.charAt(0)!='K'&&a.charAt(0)!='L'&&a.charAt(0)!='M'&&a.charAt(0)!='N'&&a.charAt(0)!='O'&&a.charAt(0)!='P'&&a.charAt(0)!='Q'&&a.charAt(0)!='R'&&a.charAt(0)!='S'&&a.charAt(0)!='T'&&a.charAt(0)!='U'&&a.charAt(0)!='V'&&a.charAt(0)!='W'&&a.charAt(0)!='X'&&a.charAt(0)!='Y'&&a.charAt(0)!='Z'
              &&a.charAt(0)!='1'&&a.charAt(0)!='2'&&a.charAt(0)!='3'&&a.charAt(0)!='4'&&a.charAt(0)!='5'&&a.charAt(0)!='6'&&a.charAt(0)!='7'&&a.charAt(0)!='8'&&a.charAt(0)!='9'&&a.charAt(0)!='0'){
              //System.out.println("aaaaaa\n");
               a = a.substring(1);
            }
          
        for(int i = 0; i < a.length(); i++){
          
          //else{
          if(a.charAt(i)!='@'&& a.charAt(0)!='a'&&a.charAt(0)!='b'&&a.charAt(0)!='c'&&a.charAt(0)!='d'&&a.charAt(0)!='e'&&a.charAt(0)!='f'&&a.charAt(0)!='g'&&a.charAt(0)!='h'&&a.charAt(0)!='i'&&a.charAt(0)!='j'&&a.charAt(0)!='k'&&a.charAt(0)!='l'&&a.charAt(0)!='m'&&a.charAt(0)!='n'&&a.charAt(0)!='o'&&a.charAt(0)!='p'&&a.charAt(0)!='q'&&a.charAt(0)!='r'&&a.charAt(0)!='s'&&a.charAt(0)!='t'&&a.charAt(0)!='u'&&a.charAt(0)!='v'&&a.charAt(0)!='w'&&a.charAt(0)!='x'&&a.charAt(0)!='y'&&a.charAt(0)!='z'&&
              a.charAt(0)!='A'&&a.charAt(0)!='B'&&a.charAt(0)!='C'&&a.charAt(0)!='D'&&a.charAt(0)!='E'&&a.charAt(0)!='F'&&a.charAt(0)!='G'&&a.charAt(0)!='H'&&a.charAt(0)!='I'&&a.charAt(0)!='J'&&a.charAt(0)!='K'&&a.charAt(0)!='L'&&a.charAt(0)!='M'&&a.charAt(0)!='N'&&a.charAt(0)!='O'&&a.charAt(0)!='P'&&a.charAt(0)!='Q'&&a.charAt(0)!='R'&&a.charAt(0)!='S'&&a.charAt(0)!='T'&&a.charAt(0)!='U'&&a.charAt(0)!='V'&&a.charAt(0)!='W'&&a.charAt(0)!='X'&&a.charAt(0)!='Y'&&a.charAt(0)!='Z'
              &&a.charAt(0)!='1'&&a.charAt(0)!='2'&&a.charAt(0)!='3'&&a.charAt(0)!='4'&&a.charAt(0)!='5'&&a.charAt(0)!='6'&&a.charAt(0)!='7'&&a.charAt(0)!='8'&&a.charAt(0)!='9'&&a.charAt(0)!='0' &&a.charAt(i)!='.'){
            a = a.substring(0,i)+a.substring(i+1);
            
            //System.out.println(i+"ccc\n");
            i--;
            //System.out.println(a+"if\n");//b.charAt(j) = a.charAt(i);
            //j++;
          }
          //} 
        }
        //a = a.replace(" ","");
        //a = a.substring(2);
        //System.out.println(a+"bbb\n");
        recipientSetEmailList.add(a);
        //System.out.println(br.readLine());
        }
      }
      fr.close();
    }
    catch(IOException e){

    }
    //Create agreement using the transient document.
    AgreementCreationResponse agreementCreationResponse =  AgreementUtils.createAgreement(recipientSetEmailList,
                                                                                          transientDocumentId,
                                                                                          AgreementUtils.DocumentIdentifierType.TRANSIENT_DOCUMENT_ID,
                                                                                          ApiUtils.getAgreementName(Constants.AGREEMENT_NAME));

    //Get agreement info using the agreement id.
    System.out.println(Constants.AGREEMENT_NAME);
    AgreementInfo agreementInfo = AgreementUtils.getAgreementInfo(agreementCreationResponse.getAgreementId());

    //Display agreement details
    ApiUtils.getLogger().info("Agreement ID = " + agreementInfo.getAgreementId());
    ApiUtils.getLogger().info("Agreement Name = " + agreementInfo.getName());
    ApiUtils.getLogger().info("Agreement  Status = " + agreementInfo.getStatus());
  }
}

