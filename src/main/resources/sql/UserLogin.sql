CREATE TABLE UserLogin
(
    userId    BIGINT,
    loginInfo JSON,
    cellphone VARCHAR(255) AS (loginInfo->>"$.cellphone"),
    PRIMARY KEY (userId),
    UNIQUE KEY uk_idx_cellphone(cellphone)
);