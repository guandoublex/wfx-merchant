package com.gxx.wfx.merchant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gxx.wfx.merchant.pojos.Good;
import com.gxx.wfx.merchant.service.GoodService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WfxMerchantApplicationTests {

	@Resource
	private RestHighLevelClient restHighLevelClient;
	@Resource
	private GoodService goodService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void testCreateIndex() throws IOException {
		CreateIndexRequest createIndexRequest = new CreateIndexRequest("index5");
		CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
		System.out.println(createIndexResponse);
	}

	/**
	 * 添加文档：将数据存入es
	 */
	@Test
	public void testCreateDocument() throws IOException {

		List<Good> goods = goodService.goodsAndCopy(null, null, null);
		IndexRequest request = new IndexRequest("goods");
		for (Good good:goods) {
			String jsonStr = objectMapper.writeValueAsString(good);
			request.id(good.getGoodId());
			request.source(jsonStr, XContentType.JSON);
			IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
			System.out.println(indexResponse);
		}
	}

	/**
	 * 搜索
	 */
	@Test
	public void testSearch() throws IOException {
		SearchRequest searchRequest = new SearchRequest("goods");

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//      searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchSourceBuilder.query(QueryBuilders.matchQuery("customerId","69609206"));
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		HighlightBuilder.Field highlightTitle = new HighlightBuilder.Field("customerId");
		highlightTitle.highlighterType("unified");
		highlightBuilder.field(highlightTitle);
		highlightBuilder.preTags("<label style='color:red'>");
		highlightBuilder.postTags("</label>");
		searchSourceBuilder.highlighter(highlightBuilder);
		searchRequest.source(searchSourceBuilder);
		SearchResponse searchResp = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		SearchHits hits = searchResp.getHits();
		for (SearchHit hit : hits){
			System.out.println(hit);
		}

	}

}
