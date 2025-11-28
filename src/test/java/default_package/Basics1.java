package default_package;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Basics1 {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://uatapi.alphaprints.in";

        Response response = RestAssured
                .given()
                    .header("storeid", "11")
                    .header("Authorization", "Bearer eyJraWQiOiIxIiwiYWxnIjoiSFMyNTYifQ.eyJ1aWQiOjExMzQxOTQsInV0eXBpZCI6MywiaWF0IjoxNzYzNzEzODgzLCJleHAiOjE3NjYzMDU4ODN9.aZpSZjulC2ptDtjSa7NCaQ_iOmqojmiH3iPQu3W1A74")
                    .header("Cookie", "PHPSESSID=14ulf4cihsllothufej9tetg91; private_content_version=60491701379d40f21ff0a8a92108df8d")
                .when()
                    .get("/rest/default/V1/myaccount/invoice/order_id/1634950")
                .then()
                    .extract().response();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:");
        System.out.println(response.prettyPrint());
    }
}
