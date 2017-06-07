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

import java.util.List;

import com.adobe.sign.model.agreements.UserAgreement;
import com.adobe.sign.model.agreements.UserAgreements;
import com.adobe.sign.utils.AgreementUtils;
import com.adobe.sign.utils.ApiException;
import com.adobe.sign.utils.ApiUtils;
import com.adobe.sign.utils.BaseUriUtils;
import com.adobe.sign.utils.Constants;
import com.adobe.sign.utils.Errors;

import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

import java.nio.charset.*;

/**
 * This sample client demonstrates how to get status of all the agreements of a user.
 *
 * <p>
 * <b>IMPORTANT</b>: Before running this sample, check that you have modified the 'Constants.java' file with appropriate access token value.
 * </p>
 */

public class GetStatusOfAgreements {

  /**
   * Entry point for this sample client program.
   */
  public static void main(String args[]) throws ApiException, IOException {
    ApiUtils.configureProperty(GetStatusOfAgreements.class.getName());
    try {
      GetStatusOfAgreements client = new GetStatusOfAgreements();
      client.run();
    }
    catch (ApiException e) {
      ApiUtils.logException(Errors.GET_AGREEMENT_STATUS, e);
      throw e;
   }
  }

  /**
   * Main work function. See the class comment for details.
   */
  private void run() throws ApiException, IOException{
    // Set the number of agreements for which status is to be printed.
    int agreementCountLimit = Constants.AGREEMENT_COUNT_LIMIT;
    
    BaseUriUtils.setBaseUri();

    //Make API call to get all the agreements of a user.
    UserAgreements userAgreements = AgreementUtils.getAllAgreements();

    //Display details of each agreement.
    List<UserAgreement> userAgreementList = userAgreements.getUserAgreementList();
    
    File f = new File("test.csv"); 
    OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f),Charset.forName("UTF-8").newEncoder()); 
    BufferedWriter fw=new BufferedWriter(write);   

    fw.write("FileName,AgreementId,Status,SendDate,Receiver\r\n");

    for(UserAgreement userAgreement : userAgreementList) {
      
      if(agreementCountLimit == 0)
        break;

      //fw.write("中文字,");
      fw.write(userAgreement.getName()+",");
      fw.write(userAgreement.getAgreementId()+",");
      fw.write(userAgreement.getStatus()+",");
      fw.write(userAgreement.getDisplayDate()+",");
      //System.out.println("zzzzzz"+userAgreement.getDisplayUserSetInfos());
      for(int i = 0; i < (userAgreement.getDisplayUserSetInfos()).size(); i++){
        fw.write(((userAgreement.getDisplayUserSetInfos()).get(i)).email);
        if(i == (userAgreement.getDisplayUserSetInfos()).size() - 1)
          fw.write("\r\n");
        else
          fw.write(",");
      }

      //fw.write(userAgreement.getDisplayUserSetInfos()+"\r\n");

      //fw.write((userAgreement.getDisplayUserSetInfos()).fullName()+"\r\n");
      //fw.write(userAgreement.getEsign());
      ApiUtils.getLogger().info("Agreement Name = " + userAgreement.getName());
      ApiUtils.getLogger().info("Agreement Id = " + userAgreement.getAgreementId());
      ApiUtils.getLogger().info("Agreement Status = " + userAgreement.getStatus());
      ApiUtils.getLogger().info("Agreement DisplayDate = " + userAgreement.getDisplayDate());
      ApiUtils.getLogger().info("Agreement DisplayUserSetInfos = " + userAgreement.getDisplayUserSetInfos());
      ApiUtils.getLogger().info("Agreement Esign = " + userAgreement.getEsign());
      //System.out.println(ApiUtils.getLogger().info("Agreement Name = " + userAgreement.getName())); 
      //System.out.println(ApiUtils.getLogger().info("Agreement Id = " + userAgreement.getAgreementId())); 
      //System.out.println(ApiUtils.getLogger().info("Agreement Status = " + userAgreement.getStatus())); 

      agreementCountLimit--;
    }
    fw.close();
  }
}

