package com.smartentities.plugins.blake2b.plugin;

import java.security.Security;

import com.orientechnologies.common.log.OLogManager;
import com.orientechnologies.orient.core.sql.OSQLEngine;
import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.config.OServerParameterConfiguration;
import com.orientechnologies.orient.server.plugin.OServerPluginAbstract;
import com.smartentities.plugins.blake2b.security.Blake2bProvider;

/**
 * 
 * @author Jignesh Dhua
 *
 */
public class Blake2bPlugin extends OServerPluginAbstract {

	public Blake2bPlugin() {
	}

	@Override
	public String getName() {
		return "blake2-plugin";
	}

	@Override
	public void startup() {
		super.startup();
		OSQLEngine.getInstance().registerFunction("blake2b", new Blake2bFunction());
		OLogManager.instance().info(this, "Blake2b function registered");
	}

	@Override
	public void config(OServer oServer, OServerParameterConfiguration[] iParams) {
		Security.addProvider(new Blake2bProvider());
	}

	@Override
	public void shutdown() {
		super.shutdown();
	}
}