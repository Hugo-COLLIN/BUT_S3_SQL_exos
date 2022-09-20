SELECT distinct Vehicule.no_imm, Vehicule.modele 
FROM Vehicule, Dossier
WHERE code_categ = 'c1'
    AND (date_retrait < '10/10/15' OR dossier.date_retour > '16/10/15')
    /*AND NOT (date_retrait > '10/10/15' AND dossier.date_retour < '13/10/15')*/
    AND Vehicule.no_imm = Dossier.no_imm;