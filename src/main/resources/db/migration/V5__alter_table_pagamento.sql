ALTER TABLE pagamento ADD COLUMN status_pagamento VARCHAR(30) CHECK
    ( status_pagamento IN ( 'ABERTO','CONCLUIDO','ATRASADO'));