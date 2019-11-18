/*
 * generated by Xtext 2.19.0
 */
package org.eclipse.mydsl.ide

import com.google.inject.Guice
import org.eclipse.mydsl.MyDslRuntimeModule
import org.eclipse.mydsl.MyDslStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class MyDslIdeSetup extends MyDslStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new MyDslRuntimeModule, new MyDslIdeModule))
	}
	
}