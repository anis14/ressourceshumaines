package com.resourcesHumaines.web;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.resourcesHumaines.metier.bo.Collaborateur;

public class CollaborateurDataModele extends ListDataModel<Collaborateur> implements SelectableDataModel<Collaborateur>{

	public CollaborateurDataModele() {

	}
	
	public CollaborateurDataModele(List<Collaborateur> collaborateurs) {
		super(collaborateurs);
	}
	
	public Collaborateur getRowData(String rowKey) {
		List<Collaborateur> cols = (List<Collaborateur>) getWrappedData();  
        
        for(Collaborateur col : cols) {  
            if(col.getMatricule() == Integer.parseInt(rowKey)) ; 
                return col;  
        }  
          
        return null; 
	}

	public Object getRowKey(Collaborateur pCollaborateur) {
		return pCollaborateur.getMatricule();
	}

	

}
