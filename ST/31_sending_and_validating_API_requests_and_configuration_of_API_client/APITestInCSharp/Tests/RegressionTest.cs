using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net;

namespace APITest
{
    [TestClass]
    public class RegressionTest : ApiService
    {
        [TestMethod]
        public void CheckListOfUsers()
        {
            var response = GetUsers("api/users?page=2");
            var content = GetContent<ListOfUsersDTO>(response);
            Assert.AreEqual(2, content.Page);
            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
            Assert.AreEqual("Michael", content.Data[0].first_name);
        }

        [TestMethod]
        public void CreateNewUser()
        {
            string payload = @"{
                                    ""Name"":""Ion"",
                                     ""Job"":""dev""
                                    }";
            var response = CreateUser("api/users", payload);
            var content = GetContent<CreateUserDTO>(response);
            Assert.AreEqual(HttpStatusCode.Created, response.StatusCode);
            Assert.AreEqual("Ion", content.Name);
            Assert.AreEqual("dev", content.Job);
        }

        [TestMethod]
        public void UpdateUserById()
        {
            string payload = @"{
                                    ""Name"":""John"",
                                    ""Job"":""QA""
                                    }";
            var response = UpdateUser("api/users/7", payload);
            var content = GetContent<CreateUserDTO>(response);
            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
            Assert.AreEqual("John", content.Name);
            Assert.AreEqual("QA", content.Job);
        }

        [TestMethod]
        public void DeleteUserById()
        {
            var response = DeleteUser("api/users/7");
            Assert.AreEqual(HttpStatusCode.NoContent, response.StatusCode);
        }

        [TestMethod]
        public void RegisterUserSuccessfully()
        {
            string payload = @"{
                                    ""Email"":""Ion"",
                                     ""Password"":""dev""
                                    }";
            var response = CreateUser("api/users", payload);
            var content = GetContent<RegisterUserDTO>(response);
            Assert.AreEqual(HttpStatusCode.Created, response.StatusCode);
            Assert.AreEqual("Ion", content.Email);
            Assert.AreEqual("dev", content.Password);
        }
    }
}