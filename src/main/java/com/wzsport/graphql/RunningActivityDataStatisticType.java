package com.wzsport.graphql;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzsport.graphql.AreaActivityType.Operator;
import com.wzsport.mapper.AreaActivityDataMapper;
import com.wzsport.mapper.AreaActivityMapper;
import com.wzsport.mapper.AreaActivityViewMapper;
import com.wzsport.mapper.AreaSportMapper;
import com.wzsport.mapper.FixLocationOutdoorSportPointMapper;
import com.wzsport.mapper.StudentMapper;
import com.wzsport.model.AreaActivity;
import com.wzsport.model.AreaActivityDataExample;
import com.wzsport.model.AreaActivityView;
import com.wzsport.model.AreaActivityViewExample;
import com.wzsport.model.FixLocationOutdoorSportPoint;
import com.wzsport.model.RunningActivityData;
import com.wzsport.model.Student;
import com.wzsport.model.StudentExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLEnumType;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;

/**
* GraphQL RunningActivityDataStatistic类型的定义及查询字段定义
* 
*/
@Controller
public class RunningActivityDataStatisticType {

    private static GraphQLObjectType type;
    
    public static GraphQLObjectType getType() {
        if(type == null) {
            type = GraphQLObjectType.newObject()
                    .name("RunningActivityDataStatistic")
                    .description("运动采集数据统计信息")
                    .field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("id")
                            .description("唯一主键")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("studentId")
                            .description("该数据关联的学生的ID")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("activityId")
                            .description("该数据关联的运动的ID")
                            .type(Scalars.GraphQLLong)
                            .build())
                    .field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("locationTotalCount")
                            .description("采集数据点的数量")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("distancePerStepAgainst")
                            .description("违背步幅采集点的数量")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("speedAgainst")
                            .description("违背速度采集点的数量")
                            .type(Scalars.GraphQLInt)
                            .build())
                    .build();
        }
        return type;
    }
    
}
