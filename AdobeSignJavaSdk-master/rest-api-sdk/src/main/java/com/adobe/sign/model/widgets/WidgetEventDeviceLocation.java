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

package com.adobe.sign.model.widgets;

import com.adobe.sign.utils.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-12T17:48:30.461+05:30")
public class WidgetEventDeviceLocation   {
  
  private Float latitude = null;
  private Float longitude = null;

  
  /**
   * Latitude coordinate
   **/
  @ApiModelProperty(required = true, value = "Latitude coordinate")
  @JsonProperty("latitude")
  /**
   * @return Float
   **/
  public Float getLatitude() {
    return latitude;
  }
  /**
   * Latitude coordinate
   * @param latitude
   **/
  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  
  /**
   * Longitude coordinate
   **/
  @ApiModelProperty(required = true, value = "Longitude coordinate")
  @JsonProperty("longitude")
  /**
   * @return Float
   **/
  public Float getLongitude() {
    return longitude;
  }
  /**
   * Longitude coordinate
   * @param longitude
   **/
  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  

  @Override
  /**
   * A string representation of the object.
   * @return String
   **/
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WidgetEventDeviceLocation {\n");
    
    sb.append("    latitude: ").append(StringUtil.toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(StringUtil.toIndentedString(longitude)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
