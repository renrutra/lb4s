package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.{CommentsRequest, ListEntriesRequest, ListsRequest}

class LetterboxdListClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdListClient" should {
    val listId = LBID("1yovK")

    "get lists" in {
      val request = ListsRequest(perPage = 5)
      val listsResponse = unauthorizedClient.lists(request)
      listsResponse.next shouldBe defined
      listsResponse.items should have length request.perPage
    }

    "get a list" in {
      val list = unauthorizedClient.list(listId)
      list.id shouldBe listId
      list.previewEntries should not be empty
      list.links should not be empty
    }

    "get a list's comments" in {
      val request = CommentsRequest(perPage = 5)
      val listCommentsResponse = unauthorizedClient.listComments(listId, request)
      listCommentsResponse.next shouldBe defined
      listCommentsResponse.items should have length request.perPage
    }

    "get a list's entries" in {
      val request = ListEntriesRequest(perPage = 5)
      val listEntriesResponse = unauthorizedClient.listEntries(listId, request)
      listEntriesResponse.next shouldBe defined
      listEntriesResponse.items should have length request.perPage
    }

    "get the member's relationship with a list" in {
      val listRelationship = authorizedClient.listRelationship(listId)
      listRelationship should not be null
    }

    "get a list's statistics" in {
      val listStatistics = authorizedClient.listStatistics(listId)
      listStatistics.list.id shouldBe listId
    }
  }
}
