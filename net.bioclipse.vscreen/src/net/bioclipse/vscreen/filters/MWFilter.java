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
public class MWFilter extends AbstractFilterWithOperator{


    private ICDKManager cdk;
    private double molWeight;
    
    public MWFilter(String dbname, String molWeight, String operator, String label, IProgressMonitor monitor) {
        super(dbname, label, operator, monitor);
        this.molWeight=Double.parseDouble( molWeight );
        cdk = 
            net.bioclipse.cdk.business.Activator.getDefault().getJavaCDKManager();
    }
    
    @Override
    public boolean doMatch( DBMolecule molecule ) throws BioclipseException {
            return compare( cdk.calculateMass( molecule), molWeight);
    }

}
