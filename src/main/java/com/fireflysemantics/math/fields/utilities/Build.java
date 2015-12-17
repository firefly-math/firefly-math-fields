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
package com.fireflysemantics.math.fields.utilities;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.fireflysemantics.math.fields.interfaces.Field;

/** Build collections of Field instances */

public class Build {

	/**
	 * Build an array of elements.
	 * <p>
	 * Arrays are filled with field.getZero()
	 *
	 * @param <T>
	 *            the type of the field elements
	 * @param field
	 *            field to which array elements belong
	 * @param length
	 *            of the array
	 * @return a new array
	 */
	public static <T> T[] array(final Field<T> field, final int length) {
		@SuppressWarnings("unchecked") // OK because field must be correct class
		T[] array = (T[]) Array.newInstance(field.getRuntimeClass(), length);
		Arrays.fill(array, field.getZero());
		return array;
	}

	/**
	 * Build a double dimension array of elements.
	 * <p>
	 * Arrays are filled with field.getZero()
	 *
	 * @param <T>
	 *            the type of the field elements
	 * @param field
	 *            field to which array elements belong
	 * @param rows
	 *            number of rows in the array
	 * @param columns
	 *            number of columns (may be negative to build partial arrays in
	 *            the same way <code>new Field[rows][]</code> works)
	 * @return a new array
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[][] array(final Field<T> field, final int rows, final int columns) {
		final T[][] array;
		if (columns < 0) {
			T[] dummyRow = array(field, 0);
			array = (T[][]) Array.newInstance(dummyRow.getClass(), rows);
		} else {
			array = (T[][]) Array.newInstance(field.getRuntimeClass(), new int[] { rows, columns });
			for (int i = 0; i < rows; ++i) {
				Arrays.fill(array[i], field.getZero());
			}
		}
		return array;
	}
}
