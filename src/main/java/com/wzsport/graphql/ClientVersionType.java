package com.wzsport.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.service.ClientVersionService;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

@Component
public class ClientVersionType {

	private static ClientVersionService clientVersionService;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition latestVerisonQueryField;
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("ClientVersion")
					.description("客户端版本信息")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.type(Scalars.GraphQLLong)
							.description("唯一主键")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("versionName")
							.type(Scalars.GraphQLString)
							.description("版本名称")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("versionCode")
							.type(Scalars.GraphQLInt)
							.description("版本号")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("changeLog")
							.type(Scalars.GraphQLString)
							.description("版本更新信息")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("downloadUrl")
							.type(Scalars.GraphQLString)
							.description("安装包下载地址")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isForced")
							.type(Scalars.GraphQLBoolean)
							.description("是否强制安装")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("platformId")
							.type(Scalars.GraphQLByte)
							.description("客户端平台Id，0：安卓；1：iOS")
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getLatestVerisonQueryField() {
		if(latestVerisonQueryField == null) {
			latestVerisonQueryField = GraphQLFieldDefinition.newFieldDefinition()
					.argument(GraphQLArgument.newArgument().name("platformId").type(Scalars.GraphQLByte).build())
	                .name("latestVerison")
	                .description("获取客户端最新版本信息")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	byte platformId = environment.getArgument("platformId");
	                	return clientVersionService.getLatestVersionInfo(platformId);
	                } ).build();
		}
        return latestVerisonQueryField;
    }
	
	@Autowired(required = true) 
	public void setAndroidVersionInfoService(ClientVersionService androidVersionInfoService) {
		ClientVersionType.clientVersionService = androidVersionInfoService;
	}
}
