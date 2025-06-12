package com.example.data_remote.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("volumeInfo") val information: InformationResponse? = null
)

data class InformationResponse(
    @SerializedName("title") val title: String? = null,
    @SerializedName("subtitle") val subtitle: String? = null,
    @SerializedName("authors") val authors: List<String>? = null,
    @SerializedName("imageLinks") val imageLinks: ImageLinksResponse? = null,
    @SerializedName("pageCount") val pageCount: Int? = null
)

data class ImageLinksResponse(
    @SerializedName("smallThumbnail") val smallThumbnail: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null
)

//"volumeInfo": {
//    "title": "Harry Potter and the Cursed Child: The Official Script Book of the Original West",
//    "subtitle": "End Production Spec",
//    "authors": [
//    "J-K Rowling",
//    "Jack Thorne",
//    "John Tiffany"
//    ],
//    "publisher": "Harry Potter (Hardcover)",
//    "publishedDate": "2016-08-22",
//    "description": "The Eighth Story. Nineteen Years Later. Based on an original new story by J.K. Rowling, Jack Thorne and John Tiffany, a new play by Jack Thorne, \"Harry Potter and the Cursed Child\" is the eighth story in the Harry Potter series and the first official Harry Potter story to be presented on stage. The play will receive its world premiere in London s West End on July 30, 2016. It was always difficult being Harry Potter and it isn t much easier now that he is an overworked employee of the Ministry of Magic, a husband and father of three school-age children. While Harry grapples with a past that refuses to stay where it belongs, his youngest son Albus must struggle with the weight of a family legacy he never wanted. As past and present fuse ominously, both father and son learn the uncomfortable truth: sometimes, darkness comes from unexpected places. \"",
//    "industryIdentifiers": [
//    {
//        "type": "ISBN_10",
//        "identifier": "0606384960"
//    },
//    {
//        "type": "ISBN_13",
//        "identifier": "9780606384964"
//    }
//    ],
//    "readingModes": {
//        "text": false,
//        "image": false
//    },
//    "pageCount": 320,
//    "printType": "BOOK",
//    "categories": [
//    "Juvenile Nonfiction"
//    ],
//    "averageRating": 3.5,
//    "ratingsCount": 3,
//    "maturityRating": "NOT_MATURE",
//    "allowAnonLogging": false,
//    "contentVersion": "preview-1.0.0",
//    "panelizationSummary": {
//        "containsEpubBubbles": false,
//        "containsImageBubbles": false
//    },
//    "imageLinks": {
//        "smallThumbnail": "http://books.google.com/books/content?id=6JbljwEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
//        "thumbnail": "http://books.google.com/books/content?id=6JbljwEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
//    },
//    "language": "en",
//    "previewLink": "http://books.google.com/books?id=6JbljwEACAAJ&dq=harry-potter&hl=&cd=1&source=gbs_api",
//    "infoLink": "http://books.google.com/books?id=6JbljwEACAAJ&dq=harry-potter&hl=&source=gbs_api",
//    "canonicalVolumeLink": "https://books.google.com/books/about/Harry_Potter_and_the_Cursed_Child_The_Of.html?hl=&id=6JbljwEACAAJ"
//},
//"saleInfo": {
//    "country": "US",
//    "saleability": "NOT_FOR_SALE",
//    "isEbook": false
//},
//"accessInfo": {
//    "country": "US",
//    "viewability": "NO_PAGES",
//    "embeddable": false,
//    "publicDomain": false,
//    "textToSpeechPermission": "ALLOWED",
//    "epub": {
//        "isAvailable": false
//    },
//    "pdf": {
//        "isAvailable": false
//    },
//    "webReaderLink": "http://play.google.com/books/reader?id=6JbljwEACAAJ&hl=&source=gbs_api",
//    "accessViewStatus": "NONE",
//    "quoteSharingAllowed": false
//},
//"searchInfo": {
//    "textSnippet": "Based on an original new story by J.K. Rowling, Jack Thorne and John Tiffany, a new play by Jack Thorne, Harry Potter and the Cursed Child is the eighth story in the Harry Potter series and the first official Harry Potter story to be ..."
//}
//},