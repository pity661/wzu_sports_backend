package com.wzsport.graphql;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.TermMapper;
import com.wzsport.mapper.TermSportsTaskMapper;
import com.wzsport.model.Term;
import com.wzsport.model.TermExample;
import com.wzsport.model.TermSportsTask;
import com.wzsport.model.TermSportsTaskExample;
import com.wzsport.util.MyDateUtil;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* Term GraphQL Type.
* 
* @author x1ny
* @date 2017年5月28日
*/
@Component
public class TermType {

	private static TermMapper termMapper;
	private static TermSportsTaskMapper termSportsTaskMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	private static GraphQLFieldDefinition pagingQueryField;

	private TermType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("Term")
					.description("学期类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("学期名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("startDate")
							.description("开始日期,时间戳(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								Term term = environment.getSource();
			                	return term.getStartDate().getTime();
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("endDate")
							.description("结束日期,时间戳(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								Term term = environment.getSource();
			                	return term.getEndDate().getTime();
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("termSportsTask")
							.description("关联的学期运动任务")
							.type(TermSportsTaskType.getType())
							.dataFetcher(environment ->  {
								Term term = environment.getSource();
								TermSportsTaskExample termSportsTaskExample = new TermSportsTaskExample();
								termSportsTaskExample.createCriteria().andTermIdEqualTo(term.getId());
			                	TermSportsTask termSportsTask = termSportsTaskMapper.selectByExample(termSportsTaskExample).get(0);
			                	return termSportsTask;
							} )
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("date").type(Scalars.GraphQLString).build())
	                .name("term")
	                .description("根据ID或者时间获取学期")
	                .type(getType())
	                .dataFetcher(environment -> {
	                	TermExample example = new TermExample();
	                	Long id = environment.getArgument("id");
	                	if (id != null) {
	                		if (id != 0) {
			                	Term term = termMapper.selectByPrimaryKey(id);
			                	return term;
	                		} else {
	                			Date dt = new Date();
	                			example.createCriteria().andStartDateLessThan(dt).andEndDateGreaterThan(dt);
	                			List<Term> list = termMapper.selectByExample(example);
	                			return list.get(0);
	                		}
	                	} else {
	                		String date = environment.getArgument("date");
	                		if (date != null) {
	                			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	                			Date dt = null;
								try {
									dt = format.parse(date);
								} catch (ParseException e) {
									e.printStackTrace();
									return null;
								}
	                			example.createCriteria().andStartDateLessThan(dt).andEndDateGreaterThan(dt);
	                			List<Term> list = termMapper.selectByExample(example);
	                			return list.get(0);
	                		}
	                	}
	                	return null;
	                } )
	                .build();
		}
		
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	                .name("terms")
	                .description("根据大学的ID获取所有学期)")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment -> {
	                	long universityId = environment.getArgument("universityId");
	                	TermExample termExample = new TermExample();
	                	termExample.createCriteria().andUniversityIdEqualTo(universityId);
	                	List<Term> termList = termMapper.selectByExample(termExample);
	                	return termList;
	                } ).build();
		}
        return listQueryField;
    }
	
	public static GraphQLFieldDefinition getPagingQueryField() {
		if(pagingQueryField == null) {
			pagingQueryField = GraphQLFieldDefinition.newFieldDefinition()
					.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
					.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
					.name("pagingTerms")
					.description("大学分页")
					.type(PageType.getPageTypeBuidler(getType())
							.name("TermPage")
							.description("学期分页")
							.build())
					.dataFetcher(environment -> {
	                	long universityId = environment.getArgument("universityId");
	                	PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
	                	TermExample termExample = new TermExample();
	                	termExample.createCriteria().andUniversityIdEqualTo(universityId);
	                	List<Term> termList = termMapper.selectByExample(termExample);
	                	return termList;
					} ).build();
		}
		return pagingQueryField;
	}
	
	@Autowired(required = true)
	public void setTermSportsTaskMapper(TermSportsTaskMapper termSportsTaskMapper) {
		TermType.termSportsTaskMapper = termSportsTaskMapper;
	}
	
	@Autowired(required = true)
	public void setTermMapper(TermMapper termMapper) {
		TermType.termMapper = termMapper;
	}
}
