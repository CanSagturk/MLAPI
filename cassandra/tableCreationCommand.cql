CREATE TABLE IF NOT EXISTS scores_db.Scores (
    id UUID,
    name varchar,
    value int,
    gameid int,
    PRIMARY KEY ((gameid), value, id)
)
WITH CLUSTERING ORDER BY (value DESC)