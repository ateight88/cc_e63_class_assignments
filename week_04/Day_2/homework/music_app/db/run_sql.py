import psycopg2
import psycopg2.extras as ext

def run_sql(sql, values=None):
    # set up var for connection
    conn = None
    # set up an empty list
    results = []
    # connect to the db
    try:
        conn = psycopg2.connect("dbname='task_manager' ")
        # get cursor
        cur = conn.cursor(cursor_factory=ext.DictCursor)
        # execute the sql
        cur.execute(sql, values)
        # commit the execution
        conn.commit()
        # get results
        results = cur.fetchall()
        # close db connection
        cur.close()
    except(Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()   
    # return the list
    return results    