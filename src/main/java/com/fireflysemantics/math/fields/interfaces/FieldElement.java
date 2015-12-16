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
package com.fireflysemantics.math.fields.interfaces;

import com.fireflysemantics.math.exceptions.MathException;

/**
 * Interface representing
 * <a href="http://mathworld.wolfram.com/Field.html">field</a> elements.
 * 
 * @param <T>
 *            the type of the field elements
 * @see Field
 */
public interface FieldElement<T> {

	/**
	 * Compute this + a.
	 * 
	 * @param a
	 *            element to add
	 * @return a new element representing this + a
	 * @throws MathException[NULL_ARGUMENT_EXCEPTION]
	 *             if {@code a} is {@code null}.
	 */
	T add(T a) throws MathException;

	/**
	 * Compute this - a.
	 * 
	 * @param a
	 *            element to subtract
	 * @return a new element representing this - a
	 * @throws MathException[NULL_ARGUMENT_EXCEPTION]
	 *             if {@code a} is {@code null}.
	 */
	T subtract(T a) throws MathException;

	/**
	 * Returns the additive inverse of {@code this} element.
	 * 
	 * @return the opposite of {@code this}.
	 */
	T negate();

	/**
	 * Compute n &times; this. Multiplication by an integer number is defined as
	 * the following sum <center> n &times; this = &sum;<sub>i=1</sub>
	 * <sup>n</sup> this. </center>
	 * 
	 * @param n
	 *            Number of times {@code this} must be added to itself.
	 * @return A new element representing n &times; this.
	 */
	T multiply(int n);

	/**
	 * Compute this &times; a.
	 * 
	 * @param a
	 *            element to multiply
	 * @return a new element representing this &times; a
	 * @throws MathException[NULL_ARGUMENT_EXCEPTION]
	 *             if {@code a} is {@code null}.
	 */
	T multiply(T a) throws MathException;

	/**
	 * Compute this &divide; a.
	 * 
	 * @param a
	 *            element to add
	 * @return a new element representing this &divide; a
	 * @throws MathException[NULL_ARGUMENT_EXCEPTION]
	 *             if {@code a} is {@code null}.
	 * @throws MathException[DIVISION_BY_ZERO_EXCEPTION]
	 *             if {@code a} is zero
	 */
	T divide(T a) throws MathException;

	/**
	 * Returns the multiplicative inverse of {@code this} element.
	 * 
	 * @return the inverse of {@code this}.
	 * @throws MathException[DIVISION_BY_ZERO_EXCEPTION]
	 *             if {@code this} is zero
	 */
	T reciprocal() throws MathException;

	/**
	 * Get the {@link Field} to which the instance belongs.
	 * 
	 * @return {@link Field} to which the instance belongs
	 */
	Field<T> getField();
}
