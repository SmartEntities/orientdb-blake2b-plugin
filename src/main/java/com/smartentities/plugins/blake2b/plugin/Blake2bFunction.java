package com.smartentities.plugins.blake2b.plugin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.orientechnologies.common.log.OLogManager;
import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.sql.functions.OSQLFunctionAbstract;
import com.smartentities.plugins.blake2b.Blake2b;
import com.smartentities.plugins.blake2b.ByteUtils;

/**
 * 
 * @author Jignesh Dhua
 *
 */
public class Blake2bFunction extends OSQLFunctionAbstract {

	public Blake2bFunction() {
		super("blake2b", 1, 2);
	}

	@Override
	public String getSyntax() {
		return "blake2b(<input>)";
	}

	@Override
	public Object execute(Object iThis, OIdentifiable iCurrentRecord, Object iCurrentResult, final Object[] iParams,
			OCommandContext iContext) {

		if (iParams.length == 0 || iParams[0] == null) {
			OLogManager.instance().error(this, "Parameter can't be empty",
					new IllegalArgumentException("Parameter can't be empty"));
			return null;
		}

		final String input = (String) iParams[0];

		MessageDigest digest = null;
		try {

			if (iParams.length > 1 && iParams[1] != null && Blake2b.BLAKE2_B_512.equals(iParams[1].toString())) {
				digest = MessageDigest.getInstance(Blake2b.BLAKE2_B_512);
			} else {
				digest = MessageDigest.getInstance(Blake2b.BLAKE2_B_256);
			}

			digest.update(input.getBytes());

			String hash = ByteUtils.bytesToHex(digest.digest());
			return hash;
		} catch (NoSuchAlgorithmException e) {
			OLogManager.instance().error(this, e.getMessage(), e);
			return null;
		}
	}
}