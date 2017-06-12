/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("http://www.amazon.com"));
	    System.out.println(urlVal.isValid("http://ldjsflkdfjdkkfdkfj.com"));
	   System.out.println(urlVal.isValid("http://oregonstate.mail.edu"));
	   System.out.println(urlVal.isValid("http://44444444444.com"));
	   System.out.println(urlVal.isValid("http://255.255.255.255"));
	   System.out.println(urlVal.isValid("http://0.0.0.0"));
	   System.out.println(urlVal.isValid("ftp://google.com"));
	   System.out.println(urlVal.isValid("http://google.com:80"));
	   System.out.println(urlVal.isValid("http://google.com/path"));
	   System.out.println(urlVal.isValid("http://google.com/path/"));
	   System.out.println(urlVal.isValid("http://google.com/#anchor"));
	   System.out.println(urlVal.isValid("http://google.com/$123"));
	   System.out.println(urlVal.isValid("http://google.com/path/file"));
	   System.out.println(urlVal.isValid("http://google.com/path?query=true"));
	   System.out.println(urlVal.isValid("http://google.com?query=true"));
	   System.out.println(urlVal.isValid("http://google.com:80/path?query=true"));
	   
	   System.out.println();
	   System.out.println("The following should return FALSE:");
	   System.out.println(urlVal.isValid("http:/amazon.com"));
	   System.out.println(urlVal.isValid("http:amazon.com"));
	   System.out.println(urlVal.isValid("amazon.com"));
	   System.out.println(urlVal.isValid("http://google"));
	   System.out.println(urlVal.isValid("http://google."));
	   System.out.println(urlVal.isValid("http://google.xxx"));
	   System.out.println(urlVal.isValid("http://google.3b2"));
	   System.out.println(urlVal.isValid("http://;$#.com"));
	   System.out.println(urlVal.isValid("http://.com"));
	   System.out.println(urlVal.isValid("http://1.2.3.4.5"));
	   System.out.println(urlVal.isValid("http://.1.2.3.4.5"));
	   System.out.println(urlVal.isValid("http://1.2.3.4.5."));
	   System.out.println(urlVal.isValid("http://1.2.3.4.a"));
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   //Testing url schemes
		System.out.println("First Partition Testing: schemes");


   		UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
   		String baseUrl = "www.google.com";

   		for (int i=0;i<testUrlScheme.length;i++) {
   			String testUrl = testUrlScheme[i].item + baseUrl;
   			boolean res = uVal.isValid(testUrl);
   			
			//if both true, test passed. Else test failed.
   			if(res == testUrlScheme[i].valid){
   				System.out.println(testUrl + " Passed scheme test");
   			}else{
   				System.out.println(testUrl + " Failed scheme test");
   			}
   		}
   		System.out.println("\n");
	   
   }
   
   public void testYourSecondPartition(){
	    //Test URL authority
   	System.out.println("Second Partition Testing: authorities");

   	UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
   	String baseUrl = "http://";

   	for (int i=0;i<testUrlAuthority.length;i++) {
   			String testUrl = baseUrl + testUrlAuthority[i].item;
   			boolean res = uVal.isValid(testUrl);
   			
   			if(res == testUrlAuthority[i].valid){
   				System.out.println(testUrl + " Passed authorities test");
   			}else{
   				System.out.println(testUrl + " Failed authorities test");
   			}
   		}
   		System.out.println("\n");
   }
   
   
   public void testIsValid()
   {
	   System.out.println("Unit testing UrlValidator.isValid()\n");
	   UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   int testsFailed = 0;
	   int testsTotal = 0;
	   
	   for(int i = 0; i < testUrlScheme.length; i++) {
		   for(int j = 0; j < testUrlAuthority.length; j++) {
			   for(int k = 0; k < testUrlPort.length; k++) {
				   for(int l = 0; l < testPath.length; l++) {
					   for(int m = 0; m < testUrlQuery.length; m++) {
						   
						   testsTotal++;
						   StringBuffer testBuffer = new StringBuffer();
						   boolean expected = true;
						   
						   testBuffer.append(testUrlScheme[i].item);
						   testBuffer.append(testUrlAuthority[j].item);
						   testBuffer.append(testUrlPort[k].item);
						   testBuffer.append(testPath[l].item);
						   testBuffer.append(testUrlQuery[m].item);
						   expected &= testUrlScheme[i].valid;
						   expected &= testUrlAuthority[j].valid;
						   expected &= testUrlPort[k].valid;
						   expected &= testPath[l].valid;
						   expected &= testUrlQuery[m].valid;
						   
						   boolean result = uVal.isValid(testBuffer.toString());
						   String status = "Passed";
						   String indices = "";
						   if(result != expected) {
							   testsFailed++;
							   status = "Failed";
							   indices = String.format("Array Indices Under Test: testUrlScheme[%d], testUrlAuthority[%d]"
									   + "testUrlPort[%d], testPath[%d], testUrlQuery[%d]", i, j, k, l, m);
						   }
						   if(printStatus)
							   System.out.println(testBuffer.toString() + " " + status + ".");
						   if(printIndex)
							   System.out.println(indices);
					   }
				   }
			   }
		   }
	   }
	   System.out.println(String.format("Total URLs Tested: %d", testsTotal));
	   System.out.println(String.format("Total Tests Failed: %d", testsFailed));
   }
   
   public void testAnyOtherUnitTest()
   {
	   System.out.println("Testing: queries");

   	UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
   	String baseUrl = "http://www.google.com";

   	for (int i=0;i<testUrlQuery.length;i++) {
   			String testUrl = baseUrl + testUrlQuery[i].item;
   			boolean res = uVal.isValid(testUrl);
   			//assertEquals(testUrlQuery[i].valid, res);
   			if(res == testUrlQuery[i].valid){
   				System.out.println(testUrl + " Passed query test");
   			}else{
   				System.out.println(testUrl + " Failed query test");
   			}
   		}
   		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}

public static void main(String args[])
   {
	   UrlValidatorTest test = new UrlValidatorTest("Url Test");
	   
	   if(args.length > 1 && (args[1].toLowerCase()).equals("true"))
		   test.printStatus = true;
	   if(args.length > 2 && (args[2].toLowerCase()).equals("true"))
		   test.printIndex = true;
	   
	   test.testManualTest();
	   test.testYourFirstPartition();
	   test.testYourSecondPartition();
	   test.testYourThirdPartition();
	   test.testYourFourthPartition();
	   test.testYourFifthPartition();
	   test.testIsValid();
	   
   }
   
   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
   							   new ResultPair("https://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:///", false),
                               new ResultPair("123http:/", false),
                               new ResultPair("http:/", false),
                               new ResultPair("--http://", false),
                               new ResultPair(".http+/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
                               new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
   								  new ResultPair("www.amazon.com", true),
   								  new ResultPair("oregonstate.edu", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("256.0.256.1", false),
                                  new ResultPair("amazon", false),
                                  new ResultPair("amazon com", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("1....2.3.4.", false),
                                  new ResultPair("beavers.gov", true),
                                  new ResultPair("foo.cn", true),
                                  new ResultPair("user@foo.gov", true),
                                  new ResultPair("255", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };

   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true),
                             new ResultPair(":8080", true),
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                             new ResultPair(":-1", false),
                             new ResultPair(":65636", true),
                             new ResultPair(":65a", false),
                             new ResultPair(":ABC", false),
   };

   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };
   
}