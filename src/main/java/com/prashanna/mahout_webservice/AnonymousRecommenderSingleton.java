/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// package org.apache.mahout.cf.taste.web;
//------------------------this is under construction............... 
//   ---------------------   by LORD PRASHANNA
package com.prashanna.mahout_webservice;

//import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.common.ClassUtils;
import com.prashanna.*;
public final class AnonymousRecommenderSingleton {

  private final RecMovieAnonymous recommender;

  private static AnonymousRecommenderSingleton instance;

  public static synchronized AnonymousRecommenderSingleton getInstance() {
    if (instance == null) {
      throw new IllegalStateException("Not initialized");
    }
    return instance;
  }

  public static synchronized void initializeIfNeeded(String recommenderClassName) {
    if (instance == null) {
      instance = new AnonymousRecommenderSingleton(recommenderClassName);
    }
  }

  private AnonymousRecommenderSingleton(String recommenderClassName) {
    if (recommenderClassName == null) {
      throw new IllegalArgumentException("Recommender class name is null");
    }
    recommender = ClassUtils.instantiateAs(recommenderClassName, com.prashanna.RecMovieAnonymous.class);
  }

  public RecMovieAnonymous getRecommender() {
    return recommender;
  
  }

}
