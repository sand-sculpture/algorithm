package com.sculpture.sand.zheng.nie.ai.spi;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.elasticsearch.index.query.BoostableQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/2 14:43
 */


public class BoolQueryBuilderExtend  extends QueryBuilder implements BoostableQueryBuilder<BoolQueryBuilderExtend> {


    private final List<QueryBuilder> mustClauses = new ArrayList<>();

    private final List<QueryBuilder> mustNotClauses = new ArrayList<>();

    private final List<QueryBuilder> filterClauses = new ArrayList<>();

    private final List<QueryBuilder> shouldClauses = new ArrayList<>();

    private float boost = -1;

    private Boolean disableCoord;

    private String minimumShouldMatch;

    private Boolean adjustPureNegative;

    private String queryName;

    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Adds a query that <b>must</b> appear in the matching documents and will
     * contribute to scoring.
     */
    public BoolQueryBuilderExtend must(QueryBuilder queryBuilder) {
        mustClauses.add(queryBuilder);
        return this;
    }

    /**
     * Adds a query that <b>must</b> appear in the matching documents but will
     * not contribute to scoring.
     */
    public BoolQueryBuilderExtend filter(QueryBuilder queryBuilder) {
        filterClauses.add(queryBuilder);
        return this;
    }

    /**
     * Adds a query that <b>must not</b> appear in the matching documents and
     * will not contribute to scoring.
     */
    public BoolQueryBuilderExtend mustNot(QueryBuilder queryBuilder) {
        mustNotClauses.add(queryBuilder);
        return this;
    }

    /**
     * Adds a query that <i>should</i> appear in the matching documents. For a boolean query with no
     * <tt>MUST</tt> clauses one or more <code>SHOULD</code> clauses must match a document
     * for the BooleanQuery to match.
     *
     * @see #minimumNumberShouldMatch(int)
     */
    public BoolQueryBuilderExtend should(QueryBuilder queryBuilder) {
        shouldClauses.add(queryBuilder);
        return this;
    }

    /**
     * Sets the boost for this query.  Documents matching this query will (in addition to the normal
     * weightings) have their score multiplied by the boost provided.
     */
    @Override
    public BoolQueryBuilderExtend boost(float boost) {
        this.boost = boost;
        return this;
    }

    /**
     * Disables <tt>Similarity#coord(int,int)</tt> in scoring. Defaults to <tt>false</tt>.
     */
    public BoolQueryBuilderExtend disableCoord(boolean disableCoord) {
        this.disableCoord = disableCoord;
        return this;
    }

    /**
     * Specifies a minimum number of the optional (should) boolean clauses which must be satisfied.
     * <p/>
     * <p>By default no optional clauses are necessary for a match
     * (unless there are no required clauses).  If this method is used,
     * then the specified number of clauses is required.
     * <p/>
     * <p>Use of this method is totally independent of specifying that
     * any specific clauses are required (or prohibited).  This number will
     * only be compared against the number of matching optional clauses.
     *
     * @param minimumNumberShouldMatch the number of optional clauses that must match
     */
    public BoolQueryBuilderExtend minimumNumberShouldMatch(int minimumNumberShouldMatch) {
        this.minimumShouldMatch = Integer.toString(minimumNumberShouldMatch);
        return this;
    }

    /**
     * Sets the minimum should match using the special syntax (for example, supporting percentage).
     */
    public BoolQueryBuilderExtend minimumShouldMatch(String minimumShouldMatch) {
        this.minimumShouldMatch = minimumShouldMatch;
        return this;
    }

    /**
     * Returns <code>true</code> iff this query builder has at least one should, must, must not or filter clause.
     * Otherwise <code>false</code>.
     */
    public boolean hasClauses() {
        return !(mustClauses.isEmpty() && shouldClauses.isEmpty() && mustNotClauses.isEmpty() && filterClauses.isEmpty());
    }

    /**
     * If a boolean query contains only negative ("must not") clauses should the
     * BooleanQuery be enhanced with a {@link MatchAllDocsQuery} in order to act
     * as a pure exclude. The default is <code>true</code>.
     */
    public BoolQueryBuilderExtend adjustPureNegative(boolean adjustPureNegative) {
        this.adjustPureNegative = adjustPureNegative;
        return this;
    }

    /**
     * Sets the query name for the filter that can be used when searching for matched_filters per hit.
     */
    public BoolQueryBuilderExtend queryName(String queryName) {
        this.queryName = queryName;
        return this;
    }

    @Override
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject("bool");
        builder.field("group", group);
        doXArrayContent("must", mustClauses, builder, params);
        doXArrayContent("filter", filterClauses, builder, params);
        doXArrayContent("must_not", mustNotClauses, builder, params);
        doXArrayContent("should", shouldClauses, builder, params);
        if (boost != -1) {
            builder.field("boost", boost);
        }
        if (disableCoord != null) {
            builder.field("disable_coord", disableCoord);
        }
        if (minimumShouldMatch != null) {
            builder.field("minimum_should_match", minimumShouldMatch);
        }
        if (adjustPureNegative != null) {
            builder.field("adjust_pure_negative", adjustPureNegative);
        }
        if (queryName != null) {
            builder.field("_name", queryName);
        }
        builder.endObject();
    }

    private void doXArrayContent(String field, List<QueryBuilder> clauses, XContentBuilder builder, Params params) throws IOException {
        if (clauses.isEmpty()) {
            return;
        }
        if (clauses.size() == 1) {
            builder.field(field);
            clauses.get(0).toXContent(builder, params);
        } else {
            builder.startArray(field);
            for (QueryBuilder clause : clauses) {
                clause.toXContent(builder, params);
            }
            builder.endArray();
        }
    }
}
