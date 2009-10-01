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

import net.bioclipse.cdk.business.ICDKManager;
import net.bioclipse.core.business.BioclipseException;
import net.bioclipse.structuredb.domain.DBMolecule;


/**
 * 
 * @author ola
 *
 */
public class MWFilter extends AbstractDoubleFilter implements IDoubleFilter{


    private ICDKManager cdk;
    
    public String getName() {
        return "MolWeight";
    }
    
    public MWFilter() {
        cdk = 
          net.bioclipse.cdk.business.Activator.getDefault().getJavaCDKManager();
    }
    
    public boolean doMatch( DBMolecule molecule ) throws BioclipseException {
            return compare( cdk.calculateMass( molecule), getThreshold());
    }

}
