package com.wzsport.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.wzsport.graphql.ClientVersionType;
import com.wzsport.graphql.AreaActivityType;
import com.wzsport.graphql.AreaSportType;
import com.wzsport.graphql.ClassType;
import com.wzsport.graphql.CollegeType;
import com.wzsport.graphql.FitnessCheckDataType;
import com.wzsport.graphql.FixLocationOutdoorSportPointType;
import com.wzsport.graphql.MajorType;
import com.wzsport.graphql.PhysicalTestType;
import com.wzsport.graphql.RunningActivityType;
import com.wzsport.graphql.RunningSportType;
import com.wzsport.graphql.SportScoreType;
import com.wzsport.graphql.SportsCourseType;
import com.wzsport.graphql.StudentCoursePhysicalTestType;
import com.wzsport.graphql.StudentType;
import com.wzsport.graphql.TeacherType;
import com.wzsport.graphql.TermSportsTaskType;
import com.wzsport.graphql.TermType;
import com.wzsport.graphql.UniversityType;
import com.wzsport.service.GraphQLService;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;


/**
* GraphQL查询服务实现类
* 
* @author x1ny
* @date 2017年5月24日
*/
@Service
public class GraphQLServiceImpl implements GraphQLService {

	private GraphQL graphQL;
	
	public GraphQLServiceImpl() {
		//创建GraphQL实例
		GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("root")
                .field(UniversityType.getSingleQueryField())
                .field(UniversityType.getListField())
                .field(CollegeType.getSingleQueryField())
                .field(CollegeType.getListQueryField())
                .field(MajorType.getSingleQueryField())
                .field(MajorType.getListQueryField())
                .field(ClassType.getSingleQueryField())
                .field(ClassType.getListQueryField())
                .field(StudentType.getSingleQueryField())
                .field(StudentType.getListQueryField())
                .field(StudentType.getListQueryByConditionsField())
                .field(TeacherType.getSingleQueryField())
                .field(TeacherType.getListTeacherByJobNoAndNameAndSex())
                .field(TeacherType.getListQueryField())
                .field(AreaSportType.getSingleQueryField())
                .field(AreaSportType.getListQueryField())
                .field(AreaActivityType.getSingleQueryField())
                .field(AreaActivityType.getListQueryField())
                .field(AreaActivityType.getSearchField())
                .field(FixLocationOutdoorSportPointType.getSingleQueryField())
                .field(FixLocationOutdoorSportPointType.getListQueryField())
                .field(RunningSportType.getSingleQueryField())
                .field(RunningSportType.getListQueryField())
                .field(RunningActivityType.getSingleQueryField())
                .field(RunningActivityType.getListQueryField())
                .field(RunningActivityType.getSearchField())
                .field(TermType.getSingleQueryField())
                .field(TermType.getListQueryField())
                .field(FitnessCheckDataType.getListQueryField())
                .field(FitnessCheckDataType.getSingleQueryField())
                .field(SportScoreType.getListQueryField())
                .field(SportScoreType.getSingleQueryField())
                .field(TermSportsTaskType.getSingleQueryField())
                .field(ClientVersionType.getLatestVerisonQueryField())
                .field(SportsCourseType.getListQueryField())
                .field(StudentCoursePhysicalTestType.getListQueryField())
                .field(PhysicalTestType.getSingleQueryField())
                .build();
		
		GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
		
		graphQL = GraphQL.newGraphQL(schema).build();
	}
	

	/* (non-Javadoc)
	 * @see com.wzsport.service.GraphQLService#query(java.lang.String)
	 */
	public ExecutionResult query(String queryString) {
		return graphQL.execute(queryString);
	}


	/* (non-Javadoc)
	 * @see com.wzsport.service.GraphQLService#query(java.lang.String, java.util.Map)
	 */
	@Override
	public ExecutionResult query(String queryString, Map<String, Object> variables) {
		return graphQL.execute(queryString, (Object) null, variables);
	}
}
