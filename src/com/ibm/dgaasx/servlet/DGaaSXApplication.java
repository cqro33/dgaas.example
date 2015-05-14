package com.ibm.dgaasx.servlet;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ibm.dgaasx.config.EnvironmentInfo;
import com.wordnik.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class DGaaSXApplication extends Application
{
	public DGaaSXApplication()
	{
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setContact("dragos.cojocari@ro.ibm.com");
		beanConfig.setDescription("Document generation as a Service Example");
		beanConfig.setVersion("1.0.0");
		beanConfig.setBasePath(EnvironmentInfo.getBaseURL());
		beanConfig.setResourcePackage(CtoFService.class.getPackage().getName());
		beanConfig.setScan(true);
	}

	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> resources = new HashSet<Class<?>>();

		resources.add(com.wordnik.swagger.jersey.listing.ApiListingResource.class);
		resources.add(com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider.class);
		resources.add(com.wordnik.swagger.jersey.listing.ApiListingResourceJSON.class);
		resources.add(com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider.class);

		resources.add(CtoFService.class);
		resources.add(MathService.class);
		resources.add(DocgenService.class);

		return resources;
	}
}