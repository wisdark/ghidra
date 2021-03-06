/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated by Together */

package ghidra.program.util;

import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Program;

/**
 * <CODE>CodeUnitLocation</CODE> provides information about the location
 * in a program within a <CODE>CodeUnit</CODE>.
 */
public class CodeUnitLocation extends ProgramLocation {

	/**
	 * Create a new <CODE>CodeUnitLocation</CODE> for the given address.
	 * The address will be adjusted to the beginning of the code unit containing
	 * that address(if it exists).  The original address can be retrieved using
	 * the "getByteAddress()" method.
	 * @param program the program for obtaining the code unit
	 * @param addr address of the location; should not be null
	 * @param componentPath if this is not null it is the path to a data
	 * component inside of another data component
	 * @param row the row within the field.
	 * @param col - the display item index on the given row. (Note most fields only have one display item per row)
	 * @param charOffset - the character offset within the display item.
	 *
	 */
	public CodeUnitLocation(Program program, Address addr, int[] componentPath, int row, int col,
			int charOffset) {
		super(program, addr, componentPath, null, row, col, charOffset);
	}

	/**
	 * Create a new <CODE>CodeUnitLocation</CODE> using the given information
	 * @param program the program for obtaining the code unit
	 * @param addr address of the location; should be on a code unit boundary.
	 * @param byteAddr the address of specific byte within the code unit at the addr address.
	 * @param componentPath if this is not null it is the path to a data
	 * component inside of another data component
	 * @param row the row within the field.
	 * @param col - the display item index on the given row. (Note most fields only have one display item per row)
	 * @param charOffset - the character offset within the display item.
	 *
	 */
	protected CodeUnitLocation(Program program, Address addr, Address byteAddr, int[] componentPath,
			int row, int col, int charOffset) {
		super(program, addr, byteAddr, componentPath, null, row, col, charOffset);
	}

	/**
	 * Create a new <CODE>CodeUnitLocation</CODE> for the given address.
	 * The address will be adjusted to the beginning of the code unit containing
	 * that address(if it exists).  The original address can be retrieved using
	 * the "getByteAddress()" method.
	 * @param program the program for obtaining the code unit
	 * @param addr address of the location; should not be null
	 * @param row the row within the field.
	 * @param col - the display item index on the given row. (Note most fields only have one display item per row)
	 * @param charOffset - the character offset within the display item.
	 *
	 */
	public CodeUnitLocation(Program program, Address addr, int row, int col, int charOffset) {
		super(program, addr, row, col, charOffset);
	}

	protected CodeUnitLocation(Program program, Address addr, int[] componentPath, Address refAddr,
			int row, int col, int charOffset) {
		super(program, addr, componentPath, refAddr, row, col, charOffset);
	}

	/**
	 * Default constructor for a code unit location needed for restoring from XML.
	 */
	public CodeUnitLocation() {
		super();
	}

	@Override
	public boolean isValid(Program p) {
		if (!super.isValid(p)) {
			return false;
		}
		return p.getListing().getCodeUnitContaining(addr) != null;
	}
}
