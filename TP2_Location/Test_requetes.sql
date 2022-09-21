SELECT distinct Vehicule.no_imm, Vehicule.modele 
FROM Vehicule, Dossier
WHERE code_categ = 'c1'
    AND (date_retrait < '10/10/15' OR dossier.date_retour > '16/10/15')
    /*AND NOT (date_retrait > '10/10/15' AND dossier.date_retour < '13/10/15')*/
    AND Vehicule.no_imm = Dossier.no_imm;
    
    
    
    
    
UPDATE Calendrier
SET paslibre = 'x'
WHERE no_imm IN(
        SELECT no_imm
        FROM Dossier
        WHERE no_imm = '1234ya54'
    )
    AND datejour BETWEEN '01/10/15' AND '03/10/15'
;
/*WHERE Dossier.no_imm IN Dossier AND Dossier.no_imm = Calendrier.no_imm ;*/

UPDATE Calendrier
SET paslibre = 'x'
WHERE no_imm = '1234ya54'
    AND datejour BETWEEN '01/10/15' AND '03/10/15'
;

UPDATE Calendrier
SET paslibre = 'x'
WHERE no_imm = '1234ya54'
    AND datejour BETWEEN
        (SELECT date_retrait
            FROM Dossier
            WHERE no_imm = '1234ya54' 
                AND (date_retrait < '01/10/15' OR dossier.date_retour > '03/10/15')
        )
        AND
        (SELECT date_retrait
            FROM Dossier
            WHERE no_imm = '1234ya54' 
                AND (date_retrait < '01/10/15' OR dossier.date_retour > '03/10/15')
        );
    
    BETWEEN '01/10/15' AND '03/10/15'
;


UPDATE Calendrier 
SET paslibre = 'x'
WHERE no_imm = '1234ya54'
    AND datejour BETWEEN '01/10/15' AND '03/10/15';

rollback;
    
    
    
UPDATE Dossier
SET date_retrait = '01/08/20', date_retour = '03/08/20'
