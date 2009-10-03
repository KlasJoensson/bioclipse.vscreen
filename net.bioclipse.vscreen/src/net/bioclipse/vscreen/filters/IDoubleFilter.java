/*******************************************************************************
 * Copyright (c) 2009 Ola Spjuth.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ola Spjuth - initial API and implementation
 ******************************************************************************/
package net.bioclipse.vscreen.filters;


/**
 * 
 * @author ola
 *
 */
public interface IDoubleFilter extends IFilter{

    public void setThreshold(double threshold);
    public double getThreshold();

    public void setOperator(String operator);
    public int getOperator();

}
