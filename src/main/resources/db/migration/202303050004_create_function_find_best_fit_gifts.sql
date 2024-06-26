DROP FUNCTION IF EXISTS find_best_fit_gifts;
CREATE FUNCTION find_best_fit_gifts(IN selectedCategories INTEGER[], IN numGifts INTEGER)
RETURNS TABLE (id INTEGER, name TEXT)
AS $$
BEGIN
    RETURN QUERY
        SELECT g.id, g.name, g.description FROM gifts g
        JOIN gift_categories gc ON g.id = gc.gift_id
        JOIN categories c ON c.id = gc.category_id
        WHERE c.id = ANY(selectedCategories)
        GROUP BY g.id, g.name, g.description
        ORDER BY COUNT(DISTINCT c.id) DESC
        LIMIT numGifts;
END;
$$ LANGUAGE plpgsql;