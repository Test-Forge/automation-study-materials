using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace APITest
{
    public partial class ListOfUsersDTO
    {
            public long Page { get; set; }
            public long PerPage { get; set; }
            public long Total { get; set; }
            public long TotalPages { get; set; }
            public List<Datum> Data { get; set; }
            public Support Support { get; set; }
        }

        public partial class Datum
        {
            public long Id { get; set; }
            public string Email { get; set; }
            public string first_name { get; set; }
            public string last_name { get; set; }
            public Uri Avatar { get; set; }
        }

        public partial class Support
        {
            public Uri Url { get; set; }
            public string Text { get; set; }
        }
}