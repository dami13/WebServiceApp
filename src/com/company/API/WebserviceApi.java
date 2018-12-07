package com.company.API;

import okhttp3.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class WebserviceApi {
    public static String UserName = "SU";
    public static String Password = "GW";
    private static WebserviceApi mInstance = new WebserviceApi();
    private static OkHttpClient mClient = new OkHttpClient();
    private static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");
    private final String URL = "http://localhost:8080/cc/ws/cc/webservice/MyClaimAPI";

    public static WebserviceApi getInstance() {
        return mInstance;
    }

    private WebserviceApi() {
    }

    private OkHttpClient getClient(){
        return mClient;
    }

    public String tryPost(String xml){
        try {
            return post(xml);
        } catch (IOException e){
            return "error " + e.getMessage();
        }
    }

    private String post(String xml) throws IOException {

        xml = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:soap1=\"http://guidewire.com/ws/soapheaders\" xmlns:myc=\"http://example.com/cc/webservice/MyClaimAPI\">\n" +
                "   <soap:Header>\n" +
                "      <soap1:gw_locale>en_US</soap1:gw_locale>\n" +
                "      <soap1:gw_language>en_US</soap1:gw_language>\n" +
                "      <soap1:authentication>\n" +
                "         <soap1:username>su</soap1:username>\n" +
                "         <soap1:password>gw</soap1:password>\n" +
                "      </soap1:authentication>\n" +
                "   </soap:Header>\n" +
                "   <soap:Body>\n" +
                "      <myc:getClaimDescription>\n" +
                "         <!--Optional:-->\n" +
                "         <myc:claimNumber>000-00-000403</myc:claimNumber>\n" +
                "      </myc:getClaimDescription>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";


        RequestBody body = RequestBody.create(XML, xml);
        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .build();

        return GetXmlParam(mClient.newCall(request).execute());
    }

    private String GetXmlParam(Response response) throws IOException {
        String xml = response.body().string();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            NodeList nodes =  doc.getDocumentElement().getElementsByTagName("return");
            return nodes.item(0).getFirstChild().getNodeValue();
            //return nodes.item(0).getChildNodes().item(0).getNodeValue();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return "Error";
    }

}
