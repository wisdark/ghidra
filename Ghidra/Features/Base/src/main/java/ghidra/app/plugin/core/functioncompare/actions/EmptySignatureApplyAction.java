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
package ghidra.app.plugin.core.functioncompare.actions;

import docking.action.MenuData;
import ghidra.program.model.listing.Function;
import ghidra.program.util.FunctionUtility;
import ghidra.util.HelpLocation;

/**
 * Action for applying skeleton function signatures from one function to another in the dual
 * decompiler or dual listing view. By skeleton, we mean signatures where all complex data types 
 * (e.g., Structures) are replaced by empty placeholder data types.
 */
public class EmptySignatureApplyAction extends AbstractFunctionComparisonApplyAction {

	/**
	 * Constructor for applying skeleton function signatures action
	 * @param owner the action owner
	 */
	public EmptySignatureApplyAction(String owner) {
		super("Function Comparison Apply Signature", owner);
		MenuData menuData =
			new MenuData(new String[] { MENU_PARENT, "Function Signature" }, null, MENU_GROUP);
		menuData.setParentMenuGroup(MENU_GROUP);
		setPopupMenuData(menuData);
		setHelpLocation(new HelpLocation(HELP_TOPIC, getName()));
	}

	@Override
	protected void applyFunctionData(Function source, Function target) throws Exception {
		FunctionUtility.applySignature(target, source, true, null);
	}

}
