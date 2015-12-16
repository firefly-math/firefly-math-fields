/**
  *  Licensed under the Apache License, Version 2.0 (the "License");
  *  you may not use this file except in compliance with the License.
  *  You may obtain a copy of the License at
  *
  *  http://www.apache.org/licenses/LICENSE-2.0
  *
  *  Unless required by applicable law or agreed to in writing, software
  *  distributed under the License is distributed on an "AS IS" BASIS,
  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *  See the License for the specific language governing permissions and
  *  limitations under the License.
  */
package com.fireflysemantics.math.fields;

import java.io.Serializable;

import com.fireflysemantics.math.fields.interfaces.Field;
import com.fireflysemantics.math.fields.interfaces.FieldElement;

/**
 * Representation of real numbers with arbitrary precision field.
 * <p>
 * This class is a singleton.
 * </p>
 * 
 * @see BigReal
 */
public class BigRealField implements Field<BigReal>, Serializable {

	/** Serializable version identifier */
	private static final long serialVersionUID = 4756431066541037559L;

	/**
	 * Private constructor for the singleton.
	 */
	private BigRealField() {
	}

	/**
	 * Get the unique instance.
	 * 
	 * @return the unique instance
	 */
	public static BigRealField getInstance() {
		return LazyHolder.INSTANCE;
	}

	/** {@inheritDoc} */
	@Override
	public BigReal getOne() {
		return BigReal.ONE;
	}

	/** {@inheritDoc} */
	@Override
	public BigReal getZero() {
		return BigReal.ZERO;
	}

	/** {@inheritDoc} */
	@Override
	public Class<? extends FieldElement<BigReal>> getRuntimeClass() {
		return BigReal.class;
	}

	// CHECKSTYLE: stop HideUtilityClassConstructor
	/**
	 * Holder for the instance.
	 * <p>
	 * We use here the Initialization On Demand Holder Idiom.
	 * </p>
	 */
	private static class LazyHolder {
		/** Cached field instance. */
		private static final BigRealField INSTANCE = new BigRealField();
	}
	// CHECKSTYLE: resume HideUtilityClassConstructor

	/**
	 * Handle deserialization of the singleton.
	 * 
	 * @return the singleton instance
	 */
	private Object readResolve() {
		// return the singleton instance
		return LazyHolder.INSTANCE;
	}

}
