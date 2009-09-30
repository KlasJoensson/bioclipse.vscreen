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

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * 
 * @author ola
 *
 */
public class SMILESFilter extends AbstractFilter{

    private ICDKManager cdk;
    private String SMILES;
    
    public SMILESFilter(String dbname, String SMILES, String label, IProgressMonitor monitor) {
        super(dbname, label, monitor);
        this.SMILES=SMILES;
        cdk = 
            net.bioclipse.cdk.business.Activator.getDefault().getJavaCDKManager();
    }
    
    @Override
    public boolean doMatch( DBMolecule molecule ) throws BioclipseException {

        if ( cdk.calculateSMILES(molecule).contains( SMILES ) ) {
            return true;
        }
        return false;
    }

}
