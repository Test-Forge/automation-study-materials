using RestSharp;

namespace APITest
{
    public class ApiService:BaseService
    {
        public IRestResponse GetUsers(string endpoint)
        {
            var url = SetUrl(endpoint);
            var request = CreateGetRequest();
            var response = GetResponse(url, request);
            return response;
        }

        public IRestResponse CreateUser(string endpoint, dynamic payload)
        {
            var url = SetUrl(endpoint);
            var request = CreatePostRequest(payload);
            var response = GetResponse(url, request);
            return response;
        }

        public IRestResponse UpdateUser(string endpoint, dynamic payload)
        {
            var url = SetUrl(endpoint);
            var request = CreatePutRequest(payload);
            var response = GetResponse(url, request);
            return response;
        }
        public IRestResponse DeleteUser(string endpoint)
        {
            var url = SetUrl(endpoint);
            var request = CreateDeleteRequest();
           var response= GetResponse(url, request);
            return response;
        }
    }
}