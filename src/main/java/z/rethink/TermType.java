package z.rethink;

public enum TermType {
    /**
     * <code>DATUM = 1;</code>
     *
     * <pre>
     * A RQL datum, stored in `datum` below.
     * </pre>
     */
    DATUM(0, 1),
    /**
     * <code>MAKE_ARRAY = 2;</code>
     *
     * <pre>
     * DATUM... -&gt; ARRAY
     * </pre>
     */
    MAKE_ARRAY(1, 2),
    /**
     * <code>MAKE_OBJ = 3;</code>
     *
     * <pre>
     * Evaluate the terms in [optargs] and make an object
     * </pre>
     */
    MAKE_OBJ(2, 3),
    /**
     * <code>VAR = 10;</code>
     *
     * <pre>
     * Takes an integer representing a variable and returns the value stored
     * in that variable.  It's the responsibility of the client to translate
     * from their local representation of a variable to a unique _non-negative_
     * integer for that variable.  (We do it this way instead of letting
     * clients provide variable names as strings to discourage
     * variable-capturing client libraries, and because it's more efficient
     * on the wire.)
     * </pre>
     */
    VAR(3, 10),
    /**
     * <code>JAVASCRIPT = 11;</code>
     *
     * <pre>
     * Takes some javascript code and executes it.
     * </pre>
     */
    JAVASCRIPT(4, 11),
    /**
     * <code>UUID = 169;</code>
     *
     * <pre>
     * STRING {timeout: !NUMBER} -&gt; Function(*)
     * </pre>
     */
    UUID(5, 169),
    /**
     * <code>HTTP = 153;</code>
     *
     * <pre>
     * Takes an HTTP URL and gets it.  If the get succeeds and
     *  returns valid JSON, it is converted into a DATUM
     * </pre>
     */
    HTTP(6, 153),
    /**
     * <code>ERROR = 12;</code>
     *
     * <pre>
     * Takes a string and throws an error with that message.
     * Inside of a `default` block, you can omit the first
     * argument to rethrow whatever error you catch (this is most
     * useful as an argument to the `default` filter optarg).
     * </pre>
     */
    ERROR(7, 12),
    /**
     * <code>IMPLICIT_VAR = 13;</code>
     *
     * <pre>
     * Takes nothing and returns a reference to the implicit variable.
     * </pre>
     */
    IMPLICIT_VAR(8, 13),
    /**
     * <code>DB = 14;</code>
     *
     * <pre>
     * * Data Operators
     * Returns a reference to a database.
     * </pre>
     */
    DB(9, 14),
    /**
     * <code>TABLE = 15;</code>
     *
     * <pre>
     * Returns a reference to a table.
     * </pre>
     */
    TABLE(10, 15),
    /**
     * <code>GET = 16;</code>
     *
     * <pre>
     * STRING, {read_mode:STRING, identifier_format:STRING} -&gt; Table
     * Gets a single element from a table by its primary or a secondary key.
     * </pre>
     */
    GET(11, 16),
    /**
     * <code>GET_ALL = 78;</code>
     *
     * <pre>
     * Table, STRING -&gt; NULL            | Table, NUMBER -&gt; NULL |
     * </pre>
     */
    GET_ALL(12, 78),
    /**
     * <code>EQ = 17;</code>
     *
     * <pre>
     * Simple DATUM Ops
     * </pre>
     */
    EQ(13, 17),
    /**
     * <code>NE = 18;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    NE(14, 18),
    /**
     * <code>LT = 19;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    LT(15, 19),
    /**
     * <code>LE = 20;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    LE(16, 20),
    /**
     * <code>GT = 21;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    GT(17, 21),
    /**
     * <code>GE = 22;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    GE(18, 22),
    /**
     * <code>NOT = 23;</code>
     *
     * <pre>
     * BOOL -&gt; BOOL
     * </pre>
     */
    NOT(19, 23),
    /**
     * <code>ADD = 24;</code>
     *
     * <pre>
     * ADD can either add two numbers or concatenate two arrays.
     * </pre>
     */
    ADD(20, 24),
    /**
     * <code>SUB = 25;</code>
     *
     * <pre>
     * NUMBER... -&gt; NUMBER
     * </pre>
     */
    SUB(21, 25),
    /**
     * <code>MUL = 26;</code>
     *
     * <pre>
     * NUMBER... -&gt; NUMBER
     * </pre>
     */
    MUL(22, 26),
    /**
     * <code>DIV = 27;</code>
     *
     * <pre>
     * NUMBER... -&gt; NUMBER
     * </pre>
     */
    DIV(23, 27),
    /**
     * <code>MOD = 28;</code>
     *
     * <pre>
     * NUMBER, NUMBER -&gt; NUMBER
     * </pre>
     */
    MOD(24, 28),
    /**
     * <code>FLOOR = 183;</code>
     *
     * <pre>
     * NUMBER -&gt; NUMBER
     * </pre>
     */
    FLOOR(25, 183),
    /**
     * <code>CEIL = 184;</code>
     *
     * <pre>
     * NUMBER -&gt; NUMBER
     * </pre>
     */
    CEIL(26, 184),
    /**
     * <code>ROUND = 185;</code>
     *
     * <pre>
     * NUMBER -&gt; NUMBER
     * </pre>
     */
    ROUND(27, 185),
    /**
     * <code>APPEND = 29;</code>
     *
     * <pre>
     * DATUM Array Ops
     * Append a single element to the end of an array (like `snoc`).
     * </pre>
     */
    APPEND(28, 29),
    /**
     * <code>PREPEND = 80;</code>
     *
     * <pre>
     * Prepend a single element to the end of an array (like `cons`).
     * </pre>
     */
    PREPEND(29, 80),
    /**
     * <code>DIFFERENCE = 95;</code>
     *
     * <pre>
     *Remove the elements of one array from another array.
     * </pre>
     */
    DIFFERENCE(30, 95),
    /**
     * <code>SET_INSERT = 88;</code>
     *
     * <pre>
     * DATUM Set Ops
     * Set ops work on arrays. They don't use actual sets and thus have
     * performance characteristics you would expect from arrays rather than
     * from sets. All set operations have the post condition that they
     * array they return contains no duplicate values.
     * </pre>
     */
    SET_INSERT(31, 88),
    /**
     * <code>SET_INTERSECTION = 89;</code>
     *
     * <pre>
     * ARRAY, ARRAY -&gt; ARRAY
     * </pre>
     */
    SET_INTERSECTION(32, 89),
    /**
     * <code>SET_UNION = 90;</code>
     *
     * <pre>
     * ARRAY, ARRAY -&gt; ARRAY
     * </pre>
     */
    SET_UNION(33, 90),
    /**
     * <code>SET_DIFFERENCE = 91;</code>
     *
     * <pre>
     * ARRAY, ARRAY -&gt; ARRAY
     * </pre>
     */
    SET_DIFFERENCE(34, 91),
    /**
     * <code>SLICE = 30;</code>
     *
     * <pre>
     * Sequence, NUMBER, NUMBER -&gt; Sequence
     * </pre>
     */
    SLICE(35, 30),
    /**
     * <code>SKIP = 70;</code>
     *
     * <pre>
     * Sequence, NUMBER -&gt; Sequence
     * </pre>
     */
    SKIP(36, 70),
    /**
     * <code>LIMIT = 71;</code>
     *
     * <pre>
     * Sequence, NUMBER -&gt; Sequence
     * </pre>
     */
    LIMIT(37, 71),
    /**
     * <code>OFFSETS_OF = 87;</code>
     *
     * <pre>
     * Sequence, DATUM -&gt; Sequence | Sequence, Function(1) -&gt; Sequence
     * </pre>
     */
    OFFSETS_OF(38, 87),
    /**
     * <code>CONTAINS = 93;</code>
     *
     * <pre>
     * Sequence, (DATUM | Function(1))... -&gt; BOOL
     * </pre>
     */
    CONTAINS(39, 93),
    /**
     * <code>GET_FIELD = 31;</code>
     *
     * <pre>
     * Stream/Object Ops
     * Get a particular field from an object, or map that over a
     * sequence.
     * </pre>
     */
    GET_FIELD(40, 31),
    /**
     * <code>KEYS = 94;</code>
     *
     * <pre>
     * | Sequence, STRING -&gt; Sequence
     * Return an array containing the keys of the object.
     * </pre>
     */
    KEYS(41, 94),
    /**
     * <code>VALUES = 186;</code>
     *
     * <pre>
     * Return an array containing the values of the object.
     * </pre>
     */
    VALUES(42, 186),
    /**
     * <code>OBJECT = 143;</code>
     *
     * <pre>
     * Creates an object
     * </pre>
     */
    OBJECT(43, 143),
    /**
     * <code>HAS_FIELDS = 32;</code>
     *
     * <pre>
     * Check whether an object contains all the specified fields,
     * or filters a sequence so that all objects inside of it
     * contain all the specified fields.
     * </pre>
     */
    HAS_FIELDS(44, 32),
    /**
     * <code>WITH_FIELDS = 96;</code>
     *
     * <pre>
     * x.with_fields(...) &lt;=&gt; x.has_fields(...).pluck(...)
     * </pre>
     */
    WITH_FIELDS(45, 96),
    /**
     * <code>PLUCK = 33;</code>
     *
     * <pre>
     * Get a subset of an object by selecting some attributes to preserve,
     * or map that over a sequence.  (Both pick and pluck, polymorphic.)
     * </pre>
     */
    PLUCK(46, 33),
    /**
     * <code>WITHOUT = 34;</code>
     *
     * <pre>
     * Get a subset of an object by selecting some attributes to discard, or
     * map that over a sequence.  (Both unpick and without, polymorphic.)
     * </pre>
     */
    WITHOUT(47, 34),
    /**
     * <code>MERGE = 35;</code>
     *
     * <pre>
     * Merge objects (right-preferential)
     * </pre>
     */
    MERGE(48, 35),
    /**
     * <code>BETWEEN_DEPRECATED = 36;</code>
     *
     * <pre>
     * Sequence Ops
     * Get all elements of a sequence between two values.
     * Half-open by default, but the openness of either side can be
     * changed by passing 'closed' or 'open for `right_bound` or
     * `left_bound`.
     * </pre>
     */
    BETWEEN_DEPRECATED(49, 36),
    /**
     * <code>BETWEEN = 182;</code>
     *
     * <pre>
     * With the newer version, clients should use `r.minval` and `r.maxval` for unboundedness
     * </pre>
     */
    BETWEEN(50, 182),
    /**
     * <code>REDUCE = 37;</code>
     *
     * <pre>
     * Sequence, Function(2) -&gt; DATUM
     * </pre>
     */
    REDUCE(51, 37),
    /**
     * <code>MAP = 38;</code>
     *
     * <pre>
     * Sequence, Function(1) -&gt; Sequence
     * </pre>
     */
    MAP(52, 38),
    /**
     * <code>FILTER = 39;</code>
     *
     * <pre>
     * Filter a sequence with either a function or a shortcut
     * object (see API docs for details).  The body of FILTER is
     * wrapped in an implicit `.default(false)`, and you can
     * change the default value by specifying the `default`
     * optarg.  If you make the default `r.error`, all errors
     * caught by `default` will be rethrown as if the `default`
     * did not exist.
     * </pre>
     */
    FILTER(53, 39),
    /**
     * <code>CONCAT_MAP = 40;</code>
     *
     * <pre>
     * Sequence, OBJECT, {default:DATUM} -&gt; Sequence
     * Map a function over a sequence and then concatenate the results together.
     * </pre>
     */
    CONCAT_MAP(54, 40),
    /**
     * <code>ORDER_BY = 41;</code>
     *
     * <pre>
     * Order a sequence based on one or more attributes.
     * </pre>
     */
    ORDER_BY(55, 41),
    /**
     * <code>DISTINCT = 42;</code>
     *
     * <pre>
     * Get all distinct elements of a sequence (like `uniq`).
     * </pre>
     */
    DISTINCT(56, 42),
    /**
     * <code>COUNT = 43;</code>
     *
     * <pre>
     * Count the number of elements in a sequence, or only the elements that match
     * a given filter.
     * </pre>
     */
    COUNT(57, 43),
    /**
     * <code>IS_EMPTY = 86;</code>
     *
     * <pre>
     * Sequence -&gt; BOOL
     * </pre>
     */
    IS_EMPTY(58, 86),
    /**
     * <code>UNION = 44;</code>
     *
     * <pre>
     * Take the union of multiple sequences (preserves duplicate elements! (use distinct)).
     * </pre>
     */
    UNION(59, 44),
    /**
     * <code>NTH = 45;</code>
     *
     * <pre>
     * Get the Nth element of a sequence.
     * </pre>
     */
    NTH(60, 45),
    /**
     * <code>BRACKET = 170;</code>
     *
     * <pre>
     * do NTH or GET_FIELD depending on target object
     * </pre>
     */
    BRACKET(61, 170),
    /**
     * <code>INNER_JOIN = 48;</code>
     *
     * <pre>
     * Sequence, Sequence, Function(2) -&gt; Sequence
     * </pre>
     */
    INNER_JOIN(62, 48),
    /**
     * <code>OUTER_JOIN = 49;</code>
     *
     * <pre>
     * Sequence, Sequence, Function(2) -&gt; Sequence
     * </pre>
     */
    OUTER_JOIN(63, 49),
    /**
     * <code>EQ_JOIN = 50;</code>
     *
     * <pre>
     * An inner-join that does an equality comparison on two attributes.
     * </pre>
     */
    EQ_JOIN(64, 50),
    /**
     * <code>ZIP = 72;</code>
     *
     * <pre>
     * Sequence -&gt; Sequence
     * </pre>
     */
    ZIP(65, 72),
    /**
     * <code>RANGE = 173;</code>
     *
     * <pre>
     * -&gt; Sequence                        [0, +inf)
     * </pre>
     */
    RANGE(66, 173),
    /**
     * <code>INSERT_AT = 82;</code>
     *
     * <pre>
     * Array Ops
     * Insert an element in to an array at a given index.
     * </pre>
     */
    INSERT_AT(67, 82),
    /**
     * <code>DELETE_AT = 83;</code>
     *
     * <pre>
     * Remove an element at a given index from an array.
     * </pre>
     */
    DELETE_AT(68, 83),
    /**
     * <code>CHANGE_AT = 84;</code>
     *
     * <pre>
     * ARRAY, NUMBER, NUMBER -&gt; ARRAY
     * Change the element at a given index of an array.
     * </pre>
     */
    CHANGE_AT(69, 84),
    /**
     * <code>SPLICE_AT = 85;</code>
     *
     * <pre>
     * Splice one array in to another array.
     * </pre>
     */
    SPLICE_AT(70, 85),
    /**
     * <code>COERCE_TO = 51;</code>
     *
     * <pre>
     * * Type Ops
     * Coerces a datum to a named type (e.g. "bool").
     * If you previously used `stream_to_array`, you should use this instead
     * with the type "array".
     * </pre>
     */
    COERCE_TO(71, 51),
    /**
     * <code>TYPE_OF = 52;</code>
     *
     * <pre>
     * Returns the named type of a datum (e.g. TYPE_OF(true) = "BOOL")
     * </pre>
     */
    TYPE_OF(72, 52),
    /**
     * <code>UPDATE = 53;</code>
     *
     * <pre>
     * * Write Ops (the OBJECTs contain data about number of errors etc.)
     * Updates all the rows in a selection.  Calls its Function with the row
     * to be updated, and then merges the result of that call.
     * </pre>
     */
    UPDATE(73, 53),
    /**
     * <code>DELETE = 54;</code>
     *
     * <pre>
     * SingleSelection, Function(1), {non_atomic:BOOL, durability:STRING, return_changes:BOOL} -&gt; OBJECT |
     * StreamSelection, OBJECT,      {non_atomic:BOOL, durability:STRING, return_changes:BOOL} -&gt; OBJECT |
     * SingleSelection, OBJECT,      {non_atomic:BOOL, durability:STRING, return_changes:BOOL} -&gt; OBJECT
     * Deletes all the rows in a selection.
     * </pre>
     */
    DELETE(74, 54),
    /**
     * <code>REPLACE = 55;</code>
     *
     * <pre>
     * Replaces all the rows in a selection.  Calls its Function with the row
     * to be replaced, and then discards it and stores the result of that
     * call.
     * </pre>
     */
    REPLACE(75, 55),
    /**
     * <code>INSERT = 56;</code>
     *
     * <pre>
     * Inserts into a table.  If `conflict` is replace, overwrites
     * entries with the same primary key.  If `conflict` is
     * update, does an update on the entry.  If `conflict` is
     * error, or is omitted, conflicts will trigger an error.
     * </pre>
     */
    INSERT(76, 56),
    /**
     * <code>DB_CREATE = 57;</code>
     *
     * <pre>
     * * Administrative OPs
     * Creates a database with a particular name.
     * </pre>
     */
    DB_CREATE(77, 57),
    /**
     * <code>DB_DROP = 58;</code>
     *
     * <pre>
     * Drops a database with a particular name.
     * </pre>
     */
    DB_DROP(78, 58),
    /**
     * <code>DB_LIST = 59;</code>
     *
     * <pre>
     * Lists all the databases by name.  (Takes no arguments)
     * </pre>
     */
    DB_LIST(79, 59),
    /**
     * <code>TABLE_CREATE = 60;</code>
     *
     * <pre>
     * Creates a table with a particular name in a particular
     * database.  (You may omit the first argument to use the
     * default database.)
     * </pre>
     */
    TABLE_CREATE(80, 60),
    /**
     * <code>TABLE_DROP = 61;</code>
     *
     * <pre>
     * Database, STRING, {primary_key:STRING, shards:NUMBER, replicas:OBJECT, primary_replica_tag:STRING} -&gt; OBJECT
     * STRING, {primary_key:STRING, shards:NUMBER, replicas:NUMBER, primary_replica_tag:STRING} -&gt; OBJECT
     * STRING, {primary_key:STRING, shards:NUMBER, replicas:OBJECT, primary_replica_tag:STRING} -&gt; OBJECT
     * Drops a table with a particular name from a particular
     * database.  (You may omit the first argument to use the
     * default database.)
     * </pre>
     */
    TABLE_DROP(81, 61),
    /**
     * <code>TABLE_LIST = 62;</code>
     *
     * <pre>
     * STRING -&gt; OBJECT
     * Lists all the tables in a particular database.  (You may
     * omit the first argument to use the default database.)
     * </pre>
     */
    TABLE_LIST(82, 62),
    /**
     * <code>CONFIG = 174;</code>
     *
     * <pre>
     *  -&gt; ARRAY
     * Returns the row in the `rethinkdb.table_config` or `rethinkdb.db_config` table
     * that corresponds to the given database or table.
     * </pre>
     */
    CONFIG(83, 174),
    /**
     * <code>STATUS = 175;</code>
     *
     * <pre>
     * Table -&gt; SingleSelection
     * Returns the row in the `rethinkdb.table_status` table that corresponds to the
     * given table.
     * </pre>
     */
    STATUS(84, 175),
    /**
     * <code>WAIT = 177;</code>
     *
     * <pre>
     * Called on a table, waits for that table to be ready for read/write operations.
     * Called on a database, waits for all of the tables in the database to be ready.
     * Returns the corresponding row or rows from the `rethinkdb.table_status` table.
     * </pre>
     */
    WAIT(85, 177),
    /**
     * <code>RECONFIGURE = 176;</code>
     *
     * <pre>
     * Database -&gt; OBJECT
     * Generates a new config for the given table, or all tables in the given database
     * The `shards` and `replicas` arguments are required. If `emergency_repair` is
     * specified, it will enter a completely different mode of repairing a table
     * which has lost half or more of its replicas.
     * </pre>
     */
    RECONFIGURE(86, 176),
    /**
     * <code>REBALANCE = 179;</code>
     *
     * <pre>
     *                  dry_run:BOOLEAN]
     *                 } -&gt; OBJECT
     * Database|Table, {shards:NUMBER, replicas:OBJECT [,
     *                  primary_replica_tag:STRING,
     *                  nonvoting_replica_tags:ARRAY,
     *                  dry_run:BOOLEAN]
     *                 } -&gt; OBJECT
     * Table, {emergency_repair:STRING, dry_run:BOOLEAN} -&gt; OBJECT
     * Balances the table's shards but leaves everything else the same. Can also be
     * applied to an entire database at once.
     * </pre>
     */
    REBALANCE(87, 179),
    /**
     * <code>SYNC = 138;</code>
     *
     * <pre>
     * Ensures that previously issued soft-durability writes are complete and
     * written to disk.
     * </pre>
     */
    SYNC(88, 138),
    /**
     * <code>INDEX_CREATE = 75;</code>
     *
     * <pre>
     * * Secondary indexes OPs
     * Creates a new secondary index with a particular name and definition.
     * </pre>
     */
    INDEX_CREATE(89, 75),
    /**
     * <code>INDEX_DROP = 76;</code>
     *
     * <pre>
     * Drops a secondary index with a particular name from the specified table.
     * </pre>
     */
    INDEX_DROP(90, 76),
    /**
     * <code>INDEX_LIST = 77;</code>
     *
     * <pre>
     * Lists all secondary indexes on a particular table.
     * </pre>
     */
    INDEX_LIST(91, 77),
    /**
     * <code>INDEX_STATUS = 139;</code>
     *
     * <pre>
     * Gets information about whether or not a set of indexes are ready to
     * be accessed. Returns a list of objects that look like this:
     * {index:STRING, ready:BOOL[, progress:NUMBER]}
     * </pre>
     */
    INDEX_STATUS(92, 139),
    /**
     * <code>INDEX_WAIT = 140;</code>
     *
     * <pre>
     * Blocks until a set of indexes are ready to be accessed. Returns the
     * same values INDEX_STATUS.
     * </pre>
     */
    INDEX_WAIT(93, 140),
    /**
     * <code>INDEX_RENAME = 156;</code>
     *
     * <pre>
     * Renames the given index to a new name
     * </pre>
     */
    INDEX_RENAME(94, 156),
    /**
     * <code>FUNCALL = 64;</code>
     *
     * <pre>
     * * Control Operators
     * Calls a function on data
     * </pre>
     */
    FUNCALL(95, 64),
    /**
     * <code>BRANCH = 65;</code>
     *
     * <pre>
     * Executes its first argument, and returns its second argument if it
     * got [true] or its third argument if it got [false] (like an `if`
     * statement).
     * </pre>
     */
    BRANCH(96, 65),
    /**
     * <code>OR = 66;</code>
     *
     * <pre>
     * Returns true if any of its arguments returns true (short-circuits).
     * </pre>
     */
    OR(97, 66),
    /**
     * <code>AND = 67;</code>
     *
     * <pre>
     * Returns true if all of its arguments return true (short-circuits).
     * </pre>
     */
    AND(98, 67),
    /**
     * <code>FOR_EACH = 68;</code>
     *
     * <pre>
     * Calls its Function with each entry in the sequence
     * and executes the array of terms that Function returns.
     * </pre>
     */
    FOR_EACH(99, 68),
    /**
     * <code>FUNC = 69;</code>
     *
     * <pre>
     * An anonymous function.  Takes an array of numbers representing
     * variables (see [VAR] above), and a [Term] to execute with those in
     * scope.  Returns a function that may be passed an array of arguments,
     * then executes the Term with those bound to the variable names.  The
     * user will never construct this directly.  We use it internally for
     * things like `map` which take a function.  The "arity" of a [Function] is
     * the number of arguments it takes.
     * For example, here's what `_X_.map{|x| x+2}` turns into:
     * Term {
     *   type = MAP;
     *   args = [_X_,
     *           Term {
     *             type = Function;
     *             args = [Term {
     *                       type = DATUM;
     *                       datum = Datum {
     *                         type = R_ARRAY;
     *                         r_array = [Datum { type = R_NUM; r_num = 1; }];
     *                       };
     *                     },
     *                     Term {
     *                       type = ADD;
     *                       args = [Term {
     *                                 type = VAR;
     *                                 args = [Term {
     *                                           type = DATUM;
     *                                           datum = Datum { type = R_NUM;
     *                                                           r_num = 1};
     *                                         }];
     *                               },
     *                               Term {
     *                                 type = DATUM;
     *                                 datum = Datum { type = R_NUM; r_num = 2; };
     *                               }];
     *                     }];
     *           }];
     * </pre>
     */
    FUNC(100, 69),
    /**
     * <code>ASC = 73;</code>
     *
     * <pre>
     * Indicates to ORDER_BY that this attribute is to be sorted in ascending order.
     * </pre>
     */
    ASC(101, 73),
    /**
     * <code>DESC = 74;</code>
     *
     * <pre>
     * Indicates to ORDER_BY that this attribute is to be sorted in descending order.
     * </pre>
     */
    DESC(102, 74),
    /**
     * <code>INFO = 79;</code>
     *
     * <pre>
     * Gets info about anything.  INFO is most commonly called on tables.
     * </pre>
     */
    INFO(103, 79),
    /**
     * <code>MATCH = 97;</code>
     *
     * <pre>
     * `a.match(b)` returns a match object if the string `a`
     * matches the regular expression `b`.
     * </pre>
     */
    MATCH(104, 97),
    /**
     * <code>UPCASE = 141;</code>
     *
     * <pre>
     * Change the case of a string.
     * </pre>
     */
    UPCASE(105, 141),
    /**
     * <code>DOWNCASE = 142;</code>
     *
     * <pre>
     * STRING -&gt; STRING
     * </pre>
     */
    DOWNCASE(106, 142),
    /**
     * <code>SAMPLE = 81;</code>
     *
     * <pre>
     * Select a number of elements from sequence with uniform distribution.
     * </pre>
     */
    SAMPLE(107, 81),
    /**
     * <code>DEFAULT = 92;</code>
     *
     * <pre>
     * Evaluates its first argument.  If that argument returns
     * NULL or throws an error related to the absence of an
     * expected value (for instance, accessing a non-existent
     * field or adding NULL to an integer), DEFAULT will either
     * return its second argument or execute it if it's a
     * function.  If the second argument is a function, it will be
     * passed either the text of the error or NULL as its
     * argument.
     * </pre>
     */
    DEFAULT(108, 92),
    /**
     * <code>JSON = 98;</code>
     *
     * <pre>
     * Parses its first argument as a json string and returns it as a
     * datum.
     * </pre>
     */
    JSON(109, 98),
    /**
     * <code>TO_JSON_STRING = 172;</code>
     *
     * <pre>
     * Returns the datum as a JSON string.
     * N.B.: we would really prefer this be named TO_JSON and that exists as
     * an alias in Python and JavaScript drivers; however it conflicts with the
     * standard `to_json` method defined by Ruby's standard json library.
     * </pre>
     */
    TO_JSON_STRING(110, 172),
    /**
     * <code>ISO8601 = 99;</code>
     *
     * <pre>
     * Parses its first arguments as an ISO 8601 time and returns it as a
     * datum.
     * </pre>
     */
    ISO8601(111, 99),
    /**
     * <code>TO_ISO8601 = 100;</code>
     *
     * <pre>
     * Prints a time as an ISO 8601 time.
     * </pre>
     */
    TO_ISO8601(112, 100),
    /**
     * <code>EPOCH_TIME = 101;</code>
     *
     * <pre>
     * Returns a time given seconds since epoch in UTC.
     * </pre>
     */
    EPOCH_TIME(113, 101),
    /**
     * <code>TO_EPOCH_TIME = 102;</code>
     *
     * <pre>
     * Returns seconds since epoch in UTC given a time.
     * </pre>
     */
    TO_EPOCH_TIME(114, 102),
    /**
     * <code>NOW = 103;</code>
     *
     * <pre>
     * The time the query was received by the server.
     * </pre>
     */
    NOW(115, 103),
    /**
     * <code>IN_TIMEZONE = 104;</code>
     *
     * <pre>
     * Puts a time into an ISO 8601 timezone.
     * </pre>
     */
    IN_TIMEZONE(116, 104),
    /**
     * <code>DURING = 105;</code>
     *
     * <pre>
     * a.during(b, c) returns whether a is in the range [b, c)
     * </pre>
     */
    DURING(117, 105),
    /**
     * <code>DATE = 106;</code>
     *
     * <pre>
     * Retrieves the date portion of a time.
     * </pre>
     */
    DATE(118, 106),
    /**
     * <code>TIME_OF_DAY = 126;</code>
     *
     * <pre>
     * x.time_of_day == x.date - x
     * </pre>
     */
    TIME_OF_DAY(119, 126),
    /**
     * <code>TIMEZONE = 127;</code>
     *
     * <pre>
     * Returns the timezone of a time.
     * </pre>
     */
    TIMEZONE(120, 127),
    /**
     * <code>YEAR = 128;</code>
     *
     * <pre>
     * These access the various components of a time.
     * </pre>
     */
    YEAR(121, 128),
    /**
     * <code>MONTH = 129;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    MONTH(122, 129),
    /**
     * <code>DAY = 130;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    DAY(123, 130),
    /**
     * <code>DAY_OF_WEEK = 131;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    DAY_OF_WEEK(124, 131),
    /**
     * <code>DAY_OF_YEAR = 132;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    DAY_OF_YEAR(125, 132),
    /**
     * <code>HOURS = 133;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    HOURS(126, 133),
    /**
     * <code>MINUTES = 134;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    MINUTES(127, 134),
    /**
     * <code>SECONDS = 135;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    SECONDS(128, 135),
    /**
     * <code>TIME = 136;</code>
     *
     * <pre>
     * Construct a time from a date and optional timezone or a
     * date+time and optional timezone.
     * </pre>
     */
    TIME(129, 136),
    /**
     * <code>MONDAY = 107;</code>
     *
     * <pre>
     * Constants for ISO 8601 days of the week.
     * </pre>
     */
    MONDAY(130, 107),
    /**
     * <code>TUESDAY = 108;</code>
     *
     * <pre>
     * -&gt; 2
     * </pre>
     */
    TUESDAY(131, 108),
    /**
     * <code>WEDNESDAY = 109;</code>
     *
     * <pre>
     * -&gt; 3
     * </pre>
     */
    WEDNESDAY(132, 109),
    /**
     * <code>THURSDAY = 110;</code>
     *
     * <pre>
     * -&gt; 4
     * </pre>
     */
    THURSDAY(133, 110),
    /**
     * <code>FRIDAY = 111;</code>
     *
     * <pre>
     * -&gt; 5
     * </pre>
     */
    FRIDAY(134, 111),
    /**
     * <code>SATURDAY = 112;</code>
     *
     * <pre>
     * -&gt; 6
     * </pre>
     */
    SATURDAY(135, 112),
    /**
     * <code>SUNDAY = 113;</code>
     *
     * <pre>
     * -&gt; 7
     * </pre>
     */
    SUNDAY(136, 113),
    /**
     * <code>JANUARY = 114;</code>
     *
     * <pre>
     * Constants for ISO 8601 months.
     * </pre>
     */
    JANUARY(137, 114),
    /**
     * <code>FEBRUARY = 115;</code>
     *
     * <pre>
     * -&gt; 2
     * </pre>
     */
    FEBRUARY(138, 115),
    /**
     * <code>MARCH = 116;</code>
     *
     * <pre>
     * -&gt; 3
     * </pre>
     */
    MARCH(139, 116),
    /**
     * <code>APRIL = 117;</code>
     *
     * <pre>
     * -&gt; 4
     * </pre>
     */
    APRIL(140, 117),
    /**
     * <code>MAY = 118;</code>
     *
     * <pre>
     * -&gt; 5
     * </pre>
     */
    MAY(141, 118),
    /**
     * <code>JUNE = 119;</code>
     *
     * <pre>
     * -&gt; 6
     * </pre>
     */
    JUNE(142, 119),
    /**
     * <code>JULY = 120;</code>
     *
     * <pre>
     * -&gt; 7
     * </pre>
     */
    JULY(143, 120),
    /**
     * <code>AUGUST = 121;</code>
     *
     * <pre>
     * -&gt; 8
     * </pre>
     */
    AUGUST(144, 121),
    /**
     * <code>SEPTEMBER = 122;</code>
     *
     * <pre>
     * -&gt; 9
     * </pre>
     */
    SEPTEMBER(145, 122),
    /**
     * <code>OCTOBER = 123;</code>
     *
     * <pre>
     * -&gt; 10
     * </pre>
     */
    OCTOBER(146, 123),
    /**
     * <code>NOVEMBER = 124;</code>
     *
     * <pre>
     * -&gt; 11
     * </pre>
     */
    NOVEMBER(147, 124),
    /**
     * <code>DECEMBER = 125;</code>
     *
     * <pre>
     * -&gt; 12
     * </pre>
     */
    DECEMBER(148, 125),
    /**
     * <code>LITERAL = 137;</code>
     *
     * <pre>
     * Indicates to MERGE to replace, or remove in case of an empty literal, the
     * other object rather than merge it.
     * </pre>
     */
    LITERAL(149, 137),
    /**
     * <code>GROUP = 144;</code>
     *
     * <pre>
     * SEQUENCE, STRING -&gt; GROUPED_SEQUENCE | SEQUENCE, FUNCTION -&gt; GROUPED_SEQUENCE
     * </pre>
     */
    GROUP(150, 144),
    /**
     * <code>SUM = 145;</code>
     */
    SUM(151, 145),
    /**
     * <code>AVG = 146;</code>
     */
    AVG(152, 146),
    /**
     * <code>MIN = 147;</code>
     */
    MIN(153, 147),
    /**
     * <code>MAX = 148;</code>
     */
    MAX(154, 148),
    /**
     * <code>SPLIT = 149;</code>
     *
     * <pre>
     * `str.split()` splits on whitespace
     * `str.split(" ")` splits on spaces only
     * `str.split(" ", 5)` splits on spaces with at most 5 results
     * `str.split(nil, 5)` splits on whitespace with at most 5 results
     * </pre>
     */
    SPLIT(155, 149),
    /**
     * <code>UNGROUP = 150;</code>
     *
     * <pre>
     * GROUPED_DATA -&gt; ARRAY
     * </pre>
     */
    UNGROUP(156, 150),
    /**
     * <code>RANDOM = 151;</code>
     *
     * <pre>
     * Takes a range of numbers and returns a random number within the range
     * </pre>
     */
    RANDOM(157, 151),
    /**
     * <code>CHANGES = 152;</code>
     *
     * <pre>
     * TABLE -&gt; STREAM
     * </pre>
     */
    CHANGES(158, 152),
    /**
     * <code>ARGS = 154;</code>
     *
     * <pre>
     * ARRAY -&gt; SPECIAL (used to splice arguments)
     * </pre>
     */
    ARGS(159, 154),
    /**
     * <code>BINARY = 155;</code>
     *
     * <pre>
     * BINARY is client-only at the moment, it is not supported on the server
     * </pre>
     */
    BINARY(160, 155),
    /**
     * <code>GEOJSON = 157;</code>
     *
     * <pre>
     * OBJECT -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    GEOJSON(161, 157),
    /**
     * <code>TO_GEOJSON = 158;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY) -&gt; OBJECT
     * </pre>
     */
    TO_GEOJSON(162, 158),
    /**
     * <code>POINT = 159;</code>
     *
     * <pre>
     * NUMBER, NUMBER -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    POINT(163, 159),
    /**
     * <code>LINE = 160;</code>
     *
     * <pre>
     * (ARRAY | PSEUDOTYPE(GEOMETRY))... -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    LINE(164, 160),
    /**
     * <code>POLYGON = 161;</code>
     *
     * <pre>
     * (ARRAY | PSEUDOTYPE(GEOMETRY))... -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    POLYGON(165, 161),
    /**
     * <code>DISTANCE = 162;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) {geo_system:STRING, unit:STRING} -&gt; NUMBER
     * </pre>
     */
    DISTANCE(166, 162),
    /**
     * <code>INTERSECTS = 163;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) -&gt; BOOL
     * </pre>
     */
    INTERSECTS(167, 163),
    /**
     * <code>INCLUDES = 164;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) -&gt; BOOL
     * </pre>
     */
    INCLUDES(168, 164),
    /**
     * <code>CIRCLE = 165;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), NUMBER {num_vertices:NUMBER, geo_system:STRING, unit:STRING, fill:BOOL} -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    CIRCLE(169, 165),
    /**
     * <code>GET_INTERSECTING = 166;</code>
     *
     * <pre>
     * TABLE, PSEUDOTYPE(GEOMETRY) {index:!STRING} -&gt; StreamSelection
     * </pre>
     */
    GET_INTERSECTING(170, 166),
    /**
     * <code>FILL = 167;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY) -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    FILL(171, 167),
    /**
     * <code>GET_NEAREST = 168;</code>
     *
     * <pre>
     * TABLE, PSEUDOTYPE(GEOMETRY) {index:!STRING, max_results:NUM, max_dist:NUM, geo_system:STRING, unit:STRING} -&gt; ARRAY
     * </pre>
     */
    GET_NEAREST(172, 168),
    /**
     * <code>POLYGON_SUB = 171;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    POLYGON_SUB(173, 171),
    /**
     * <code>MINVAL = 180;</code>
     *
     * <pre>
     * Constants for specifying key ranges
     * </pre>
     */
    MINVAL(174, 180),
    /**
     * <code>MAXVAL = 181;</code>
     */
    MAXVAL(175, 181),
    ;

    /**
     * <code>DATUM = 1;</code>
     *
     * <pre>
     * A RQL datum, stored in `datum` below.
     * </pre>
     */
    public static final int DATUM_VALUE = 1;
    /**
     * <code>MAKE_ARRAY = 2;</code>
     *
     * <pre>
     * DATUM... -&gt; ARRAY
     * </pre>
     */
    public static final int MAKE_ARRAY_VALUE = 2;
    /**
     * <code>MAKE_OBJ = 3;</code>
     *
     * <pre>
     * Evaluate the terms in [optargs] and make an object
     * </pre>
     */
    public static final int MAKE_OBJ_VALUE = 3;
    /**
     * <code>VAR = 10;</code>
     *
     * <pre>
     * Takes an integer representing a variable and returns the value stored
     * in that variable.  It's the responsibility of the client to translate
     * from their local representation of a variable to a unique _non-negative_
     * integer for that variable.  (We do it this way instead of letting
     * clients provide variable names as strings to discourage
     * variable-capturing client libraries, and because it's more efficient
     * on the wire.)
     * </pre>
     */
    public static final int VAR_VALUE = 10;
    /**
     * <code>JAVASCRIPT = 11;</code>
     *
     * <pre>
     * Takes some javascript code and executes it.
     * </pre>
     */
    public static final int JAVASCRIPT_VALUE = 11;
    /**
     * <code>UUID = 169;</code>
     *
     * <pre>
     * STRING {timeout: !NUMBER} -&gt; Function(*)
     * </pre>
     */
    public static final int UUID_VALUE = 169;
    /**
     * <code>HTTP = 153;</code>
     *
     * <pre>
     * Takes an HTTP URL and gets it.  If the get succeeds and
     *  returns valid JSON, it is converted into a DATUM
     * </pre>
     */
    public static final int HTTP_VALUE = 153;
    /**
     * <code>ERROR = 12;</code>
     *
     * <pre>
     * Takes a string and throws an error with that message.
     * Inside of a `default` block, you can omit the first
     * argument to rethrow whatever error you catch (this is most
     * useful as an argument to the `default` filter optarg).
     * </pre>
     */
    public static final int ERROR_VALUE = 12;
    /**
     * <code>IMPLICIT_VAR = 13;</code>
     *
     * <pre>
     * Takes nothing and returns a reference to the implicit variable.
     * </pre>
     */
    public static final int IMPLICIT_VAR_VALUE = 13;
    /**
     * <code>DB = 14;</code>
     *
     * <pre>
     * * Data Operators
     * Returns a reference to a database.
     * </pre>
     */
    public static final int DB_VALUE = 14;
    /**
     * <code>TABLE = 15;</code>
     *
     * <pre>
     * Returns a reference to a table.
     * </pre>
     */
    public static final int TABLE_VALUE = 15;
    /**
     * <code>GET = 16;</code>
     *
     * <pre>
     * STRING, {read_mode:STRING, identifier_format:STRING} -&gt; Table
     * Gets a single element from a table by its primary or a secondary key.
     * </pre>
     */
    public static final int GET_VALUE = 16;
    /**
     * <code>GET_ALL = 78;</code>
     *
     * <pre>
     * Table, STRING -&gt; NULL            | Table, NUMBER -&gt; NULL |
     * </pre>
     */
    public static final int GET_ALL_VALUE = 78;
    /**
     * <code>EQ = 17;</code>
     *
     * <pre>
     * Simple DATUM Ops
     * </pre>
     */
    public static final int EQ_VALUE = 17;
    /**
     * <code>NE = 18;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    public static final int NE_VALUE = 18;
    /**
     * <code>LT = 19;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    public static final int LT_VALUE = 19;
    /**
     * <code>LE = 20;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    public static final int LE_VALUE = 20;
    /**
     * <code>GT = 21;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    public static final int GT_VALUE = 21;
    /**
     * <code>GE = 22;</code>
     *
     * <pre>
     * DATUM... -&gt; BOOL
     * </pre>
     */
    public static final int GE_VALUE = 22;
    /**
     * <code>NOT = 23;</code>
     *
     * <pre>
     * BOOL -&gt; BOOL
     * </pre>
     */
    public static final int NOT_VALUE = 23;
    /**
     * <code>ADD = 24;</code>
     *
     * <pre>
     * ADD can either add two numbers or concatenate two arrays.
     * </pre>
     */
    public static final int ADD_VALUE = 24;
    /**
     * <code>SUB = 25;</code>
     *
     * <pre>
     * NUMBER... -&gt; NUMBER
     * </pre>
     */
    public static final int SUB_VALUE = 25;
    /**
     * <code>MUL = 26;</code>
     *
     * <pre>
     * NUMBER... -&gt; NUMBER
     * </pre>
     */
    public static final int MUL_VALUE = 26;
    /**
     * <code>DIV = 27;</code>
     *
     * <pre>
     * NUMBER... -&gt; NUMBER
     * </pre>
     */
    public static final int DIV_VALUE = 27;
    /**
     * <code>MOD = 28;</code>
     *
     * <pre>
     * NUMBER, NUMBER -&gt; NUMBER
     * </pre>
     */
    public static final int MOD_VALUE = 28;
    /**
     * <code>FLOOR = 183;</code>
     *
     * <pre>
     * NUMBER -&gt; NUMBER
     * </pre>
     */
    public static final int FLOOR_VALUE = 183;
    /**
     * <code>CEIL = 184;</code>
     *
     * <pre>
     * NUMBER -&gt; NUMBER
     * </pre>
     */
    public static final int CEIL_VALUE = 184;
    /**
     * <code>ROUND = 185;</code>
     *
     * <pre>
     * NUMBER -&gt; NUMBER
     * </pre>
     */
    public static final int ROUND_VALUE = 185;
    /**
     * <code>APPEND = 29;</code>
     *
     * <pre>
     * DATUM Array Ops
     * Append a single element to the end of an array (like `snoc`).
     * </pre>
     */
    public static final int APPEND_VALUE = 29;
    /**
     * <code>PREPEND = 80;</code>
     *
     * <pre>
     * Prepend a single element to the end of an array (like `cons`).
     * </pre>
     */
    public static final int PREPEND_VALUE = 80;
    /**
     * <code>DIFFERENCE = 95;</code>
     *
     * <pre>
     *Remove the elements of one array from another array.
     * </pre>
     */
    public static final int DIFFERENCE_VALUE = 95;
    /**
     * <code>SET_INSERT = 88;</code>
     *
     * <pre>
     * DATUM Set Ops
     * Set ops work on arrays. They don't use actual sets and thus have
     * performance characteristics you would expect from arrays rather than
     * from sets. All set operations have the post condition that they
     * array they return contains no duplicate values.
     * </pre>
     */
    public static final int SET_INSERT_VALUE = 88;
    /**
     * <code>SET_INTERSECTION = 89;</code>
     *
     * <pre>
     * ARRAY, ARRAY -&gt; ARRAY
     * </pre>
     */
    public static final int SET_INTERSECTION_VALUE = 89;
    /**
     * <code>SET_UNION = 90;</code>
     *
     * <pre>
     * ARRAY, ARRAY -&gt; ARRAY
     * </pre>
     */
    public static final int SET_UNION_VALUE = 90;
    /**
     * <code>SET_DIFFERENCE = 91;</code>
     *
     * <pre>
     * ARRAY, ARRAY -&gt; ARRAY
     * </pre>
     */
    public static final int SET_DIFFERENCE_VALUE = 91;
    /**
     * <code>SLICE = 30;</code>
     *
     * <pre>
     * Sequence, NUMBER, NUMBER -&gt; Sequence
     * </pre>
     */
    public static final int SLICE_VALUE = 30;
    /**
     * <code>SKIP = 70;</code>
     *
     * <pre>
     * Sequence, NUMBER -&gt; Sequence
     * </pre>
     */
    public static final int SKIP_VALUE = 70;
    /**
     * <code>LIMIT = 71;</code>
     *
     * <pre>
     * Sequence, NUMBER -&gt; Sequence
     * </pre>
     */
    public static final int LIMIT_VALUE = 71;
    /**
     * <code>OFFSETS_OF = 87;</code>
     *
     * <pre>
     * Sequence, DATUM -&gt; Sequence | Sequence, Function(1) -&gt; Sequence
     * </pre>
     */
    public static final int OFFSETS_OF_VALUE = 87;
    /**
     * <code>CONTAINS = 93;</code>
     *
     * <pre>
     * Sequence, (DATUM | Function(1))... -&gt; BOOL
     * </pre>
     */
    public static final int CONTAINS_VALUE = 93;
    /**
     * <code>GET_FIELD = 31;</code>
     *
     * <pre>
     * Stream/Object Ops
     * Get a particular field from an object, or map that over a
     * sequence.
     * </pre>
     */
    public static final int GET_FIELD_VALUE = 31;
    /**
     * <code>KEYS = 94;</code>
     *
     * <pre>
     * | Sequence, STRING -&gt; Sequence
     * Return an array containing the keys of the object.
     * </pre>
     */
    public static final int KEYS_VALUE = 94;
    /**
     * <code>VALUES = 186;</code>
     *
     * <pre>
     * Return an array containing the values of the object.
     * </pre>
     */
    public static final int VALUES_VALUE = 186;
    /**
     * <code>OBJECT = 143;</code>
     *
     * <pre>
     * Creates an object
     * </pre>
     */
    public static final int OBJECT_VALUE = 143;
    /**
     * <code>HAS_FIELDS = 32;</code>
     *
     * <pre>
     * Check whether an object contains all the specified fields,
     * or filters a sequence so that all objects inside of it
     * contain all the specified fields.
     * </pre>
     */
    public static final int HAS_FIELDS_VALUE = 32;
    /**
     * <code>WITH_FIELDS = 96;</code>
     *
     * <pre>
     * x.with_fields(...) &lt;=&gt; x.has_fields(...).pluck(...)
     * </pre>
     */
    public static final int WITH_FIELDS_VALUE = 96;
    /**
     * <code>PLUCK = 33;</code>
     *
     * <pre>
     * Get a subset of an object by selecting some attributes to preserve,
     * or map that over a sequence.  (Both pick and pluck, polymorphic.)
     * </pre>
     */
    public static final int PLUCK_VALUE = 33;
    /**
     * <code>WITHOUT = 34;</code>
     *
     * <pre>
     * Get a subset of an object by selecting some attributes to discard, or
     * map that over a sequence.  (Both unpick and without, polymorphic.)
     * </pre>
     */
    public static final int WITHOUT_VALUE = 34;
    /**
     * <code>MERGE = 35;</code>
     *
     * <pre>
     * Merge objects (right-preferential)
     * </pre>
     */
    public static final int MERGE_VALUE = 35;
    /**
     * <code>BETWEEN_DEPRECATED = 36;</code>
     *
     * <pre>
     * Sequence Ops
     * Get all elements of a sequence between two values.
     * Half-open by default, but the openness of either side can be
     * changed by passing 'closed' or 'open for `right_bound` or
     * `left_bound`.
     * </pre>
     */
    public static final int BETWEEN_DEPRECATED_VALUE = 36;
    /**
     * <code>BETWEEN = 182;</code>
     *
     * <pre>
     * With the newer version, clients should use `r.minval` and `r.maxval` for unboundedness
     * </pre>
     */
    public static final int BETWEEN_VALUE = 182;
    /**
     * <code>REDUCE = 37;</code>
     *
     * <pre>
     * Sequence, Function(2) -&gt; DATUM
     * </pre>
     */
    public static final int REDUCE_VALUE = 37;
    /**
     * <code>MAP = 38;</code>
     *
     * <pre>
     * Sequence, Function(1) -&gt; Sequence
     * </pre>
     */
    public static final int MAP_VALUE = 38;
    /**
     * <code>FILTER = 39;</code>
     *
     * <pre>
     * Filter a sequence with either a function or a shortcut
     * object (see API docs for details).  The body of FILTER is
     * wrapped in an implicit `.default(false)`, and you can
     * change the default value by specifying the `default`
     * optarg.  If you make the default `r.error`, all errors
     * caught by `default` will be rethrown as if the `default`
     * did not exist.
     * </pre>
     */
    public static final int FILTER_VALUE = 39;
    /**
     * <code>CONCAT_MAP = 40;</code>
     *
     * <pre>
     * Sequence, OBJECT, {default:DATUM} -&gt; Sequence
     * Map a function over a sequence and then concatenate the results together.
     * </pre>
     */
    public static final int CONCAT_MAP_VALUE = 40;
    /**
     * <code>ORDER_BY = 41;</code>
     *
     * <pre>
     * Order a sequence based on one or more attributes.
     * </pre>
     */
    public static final int ORDER_BY_VALUE = 41;
    /**
     * <code>DISTINCT = 42;</code>
     *
     * <pre>
     * Get all distinct elements of a sequence (like `uniq`).
     * </pre>
     */
    public static final int DISTINCT_VALUE = 42;
    /**
     * <code>COUNT = 43;</code>
     *
     * <pre>
     * Count the number of elements in a sequence, or only the elements that match
     * a given filter.
     * </pre>
     */
    public static final int COUNT_VALUE = 43;
    /**
     * <code>IS_EMPTY = 86;</code>
     *
     * <pre>
     * Sequence -&gt; BOOL
     * </pre>
     */
    public static final int IS_EMPTY_VALUE = 86;
    /**
     * <code>UNION = 44;</code>
     *
     * <pre>
     * Take the union of multiple sequences (preserves duplicate elements! (use distinct)).
     * </pre>
     */
    public static final int UNION_VALUE = 44;
    /**
     * <code>NTH = 45;</code>
     *
     * <pre>
     * Get the Nth element of a sequence.
     * </pre>
     */
    public static final int NTH_VALUE = 45;
    /**
     * <code>BRACKET = 170;</code>
     *
     * <pre>
     * do NTH or GET_FIELD depending on target object
     * </pre>
     */
    public static final int BRACKET_VALUE = 170;
    /**
     * <code>INNER_JOIN = 48;</code>
     *
     * <pre>
     * Sequence, Sequence, Function(2) -&gt; Sequence
     * </pre>
     */
    public static final int INNER_JOIN_VALUE = 48;
    /**
     * <code>OUTER_JOIN = 49;</code>
     *
     * <pre>
     * Sequence, Sequence, Function(2) -&gt; Sequence
     * </pre>
     */
    public static final int OUTER_JOIN_VALUE = 49;
    /**
     * <code>EQ_JOIN = 50;</code>
     *
     * <pre>
     * An inner-join that does an equality comparison on two attributes.
     * </pre>
     */
    public static final int EQ_JOIN_VALUE = 50;
    /**
     * <code>ZIP = 72;</code>
     *
     * <pre>
     * Sequence -&gt; Sequence
     * </pre>
     */
    public static final int ZIP_VALUE = 72;
    /**
     * <code>RANGE = 173;</code>
     *
     * <pre>
     * -&gt; Sequence                        [0, +inf)
     * </pre>
     */
    public static final int RANGE_VALUE = 173;
    /**
     * <code>INSERT_AT = 82;</code>
     *
     * <pre>
     * Array Ops
     * Insert an element in to an array at a given index.
     * </pre>
     */
    public static final int INSERT_AT_VALUE = 82;
    /**
     * <code>DELETE_AT = 83;</code>
     *
     * <pre>
     * Remove an element at a given index from an array.
     * </pre>
     */
    public static final int DELETE_AT_VALUE = 83;
    /**
     * <code>CHANGE_AT = 84;</code>
     *
     * <pre>
     * ARRAY, NUMBER, NUMBER -&gt; ARRAY
     * Change the element at a given index of an array.
     * </pre>
     */
    public static final int CHANGE_AT_VALUE = 84;
    /**
     * <code>SPLICE_AT = 85;</code>
     *
     * <pre>
     * Splice one array in to another array.
     * </pre>
     */
    public static final int SPLICE_AT_VALUE = 85;
    /**
     * <code>COERCE_TO = 51;</code>
     *
     * <pre>
     * * Type Ops
     * Coerces a datum to a named type (e.g. "bool").
     * If you previously used `stream_to_array`, you should use this instead
     * with the type "array".
     * </pre>
     */
    public static final int COERCE_TO_VALUE = 51;
    /**
     * <code>TYPE_OF = 52;</code>
     *
     * <pre>
     * Returns the named type of a datum (e.g. TYPE_OF(true) = "BOOL")
     * </pre>
     */
    public static final int TYPE_OF_VALUE = 52;
    /**
     * <code>UPDATE = 53;</code>
     *
     * <pre>
     * * Write Ops (the OBJECTs contain data about number of errors etc.)
     * Updates all the rows in a selection.  Calls its Function with the row
     * to be updated, and then merges the result of that call.
     * </pre>
     */
    public static final int UPDATE_VALUE = 53;
    /**
     * <code>DELETE = 54;</code>
     *
     * <pre>
     * SingleSelection, Function(1), {non_atomic:BOOL, durability:STRING, return_changes:BOOL} -&gt; OBJECT |
     * StreamSelection, OBJECT,      {non_atomic:BOOL, durability:STRING, return_changes:BOOL} -&gt; OBJECT |
     * SingleSelection, OBJECT,      {non_atomic:BOOL, durability:STRING, return_changes:BOOL} -&gt; OBJECT
     * Deletes all the rows in a selection.
     * </pre>
     */
    public static final int DELETE_VALUE = 54;
    /**
     * <code>REPLACE = 55;</code>
     *
     * <pre>
     * Replaces all the rows in a selection.  Calls its Function with the row
     * to be replaced, and then discards it and stores the result of that
     * call.
     * </pre>
     */
    public static final int REPLACE_VALUE = 55;
    /**
     * <code>INSERT = 56;</code>
     *
     * <pre>
     * Inserts into a table.  If `conflict` is replace, overwrites
     * entries with the same primary key.  If `conflict` is
     * update, does an update on the entry.  If `conflict` is
     * error, or is omitted, conflicts will trigger an error.
     * </pre>
     */
    public static final int INSERT_VALUE = 56;
    /**
     * <code>DB_CREATE = 57;</code>
     *
     * <pre>
     * * Administrative OPs
     * Creates a database with a particular name.
     * </pre>
     */
    public static final int DB_CREATE_VALUE = 57;
    /**
     * <code>DB_DROP = 58;</code>
     *
     * <pre>
     * Drops a database with a particular name.
     * </pre>
     */
    public static final int DB_DROP_VALUE = 58;
    /**
     * <code>DB_LIST = 59;</code>
     *
     * <pre>
     * Lists all the databases by name.  (Takes no arguments)
     * </pre>
     */
    public static final int DB_LIST_VALUE = 59;
    /**
     * <code>TABLE_CREATE = 60;</code>
     *
     * <pre>
     * Creates a table with a particular name in a particular
     * database.  (You may omit the first argument to use the
     * default database.)
     * </pre>
     */
    public static final int TABLE_CREATE_VALUE = 60;
    /**
     * <code>TABLE_DROP = 61;</code>
     *
     * <pre>
     * Database, STRING, {primary_key:STRING, shards:NUMBER, replicas:OBJECT, primary_replica_tag:STRING} -&gt; OBJECT
     * STRING, {primary_key:STRING, shards:NUMBER, replicas:NUMBER, primary_replica_tag:STRING} -&gt; OBJECT
     * STRING, {primary_key:STRING, shards:NUMBER, replicas:OBJECT, primary_replica_tag:STRING} -&gt; OBJECT
     * Drops a table with a particular name from a particular
     * database.  (You may omit the first argument to use the
     * default database.)
     * </pre>
     */
    public static final int TABLE_DROP_VALUE = 61;
    /**
     * <code>TABLE_LIST = 62;</code>
     *
     * <pre>
     * STRING -&gt; OBJECT
     * Lists all the tables in a particular database.  (You may
     * omit the first argument to use the default database.)
     * </pre>
     */
    public static final int TABLE_LIST_VALUE = 62;
    /**
     * <code>CONFIG = 174;</code>
     *
     * <pre>
     *  -&gt; ARRAY
     * Returns the row in the `rethinkdb.table_config` or `rethinkdb.db_config` table
     * that corresponds to the given database or table.
     * </pre>
     */
    public static final int CONFIG_VALUE = 174;
    /**
     * <code>STATUS = 175;</code>
     *
     * <pre>
     * Table -&gt; SingleSelection
     * Returns the row in the `rethinkdb.table_status` table that corresponds to the
     * given table.
     * </pre>
     */
    public static final int STATUS_VALUE = 175;
    /**
     * <code>WAIT = 177;</code>
     *
     * <pre>
     * Called on a table, waits for that table to be ready for read/write operations.
     * Called on a database, waits for all of the tables in the database to be ready.
     * Returns the corresponding row or rows from the `rethinkdb.table_status` table.
     * </pre>
     */
    public static final int WAIT_VALUE = 177;
    /**
     * <code>RECONFIGURE = 176;</code>
     *
     * <pre>
     * Database -&gt; OBJECT
     * Generates a new config for the given table, or all tables in the given database
     * The `shards` and `replicas` arguments are required. If `emergency_repair` is
     * specified, it will enter a completely different mode of repairing a table
     * which has lost half or more of its replicas.
     * </pre>
     */
    public static final int RECONFIGURE_VALUE = 176;
    /**
     * <code>REBALANCE = 179;</code>
     *
     * <pre>
     *                  dry_run:BOOLEAN]
     *                 } -&gt; OBJECT
     * Database|Table, {shards:NUMBER, replicas:OBJECT [,
     *                  primary_replica_tag:STRING,
     *                  nonvoting_replica_tags:ARRAY,
     *                  dry_run:BOOLEAN]
     *                 } -&gt; OBJECT
     * Table, {emergency_repair:STRING, dry_run:BOOLEAN} -&gt; OBJECT
     * Balances the table's shards but leaves everything else the same. Can also be
     * applied to an entire database at once.
     * </pre>
     */
    public static final int REBALANCE_VALUE = 179;
    /**
     * <code>SYNC = 138;</code>
     *
     * <pre>
     * Ensures that previously issued soft-durability writes are complete and
     * written to disk.
     * </pre>
     */
    public static final int SYNC_VALUE = 138;
    /**
     * <code>INDEX_CREATE = 75;</code>
     *
     * <pre>
     * * Secondary indexes OPs
     * Creates a new secondary index with a particular name and definition.
     * </pre>
     */
    public static final int INDEX_CREATE_VALUE = 75;
    /**
     * <code>INDEX_DROP = 76;</code>
     *
     * <pre>
     * Drops a secondary index with a particular name from the specified table.
     * </pre>
     */
    public static final int INDEX_DROP_VALUE = 76;
    /**
     * <code>INDEX_LIST = 77;</code>
     *
     * <pre>
     * Lists all secondary indexes on a particular table.
     * </pre>
     */
    public static final int INDEX_LIST_VALUE = 77;
    /**
     * <code>INDEX_STATUS = 139;</code>
     *
     * <pre>
     * Gets information about whether or not a set of indexes are ready to
     * be accessed. Returns a list of objects that look like this:
     * {index:STRING, ready:BOOL[, progress:NUMBER]}
     * </pre>
     */
    public static final int INDEX_STATUS_VALUE = 139;
    /**
     * <code>INDEX_WAIT = 140;</code>
     *
     * <pre>
     * Blocks until a set of indexes are ready to be accessed. Returns the
     * same values INDEX_STATUS.
     * </pre>
     */
    public static final int INDEX_WAIT_VALUE = 140;
    /**
     * <code>INDEX_RENAME = 156;</code>
     *
     * <pre>
     * Renames the given index to a new name
     * </pre>
     */
    public static final int INDEX_RENAME_VALUE = 156;
    /**
     * <code>FUNCALL = 64;</code>
     *
     * <pre>
     * * Control Operators
     * Calls a function on data
     * </pre>
     */
    public static final int FUNCALL_VALUE = 64;
    /**
     * <code>BRANCH = 65;</code>
     *
     * <pre>
     * Executes its first argument, and returns its second argument if it
     * got [true] or its third argument if it got [false] (like an `if`
     * statement).
     * </pre>
     */
    public static final int BRANCH_VALUE = 65;
    /**
     * <code>OR = 66;</code>
     *
     * <pre>
     * Returns true if any of its arguments returns true (short-circuits).
     * </pre>
     */
    public static final int OR_VALUE = 66;
    /**
     * <code>AND = 67;</code>
     *
     * <pre>
     * Returns true if all of its arguments return true (short-circuits).
     * </pre>
     */
    public static final int AND_VALUE = 67;
    /**
     * <code>FOR_EACH = 68;</code>
     *
     * <pre>
     * Calls its Function with each entry in the sequence
     * and executes the array of terms that Function returns.
     * </pre>
     */
    public static final int FOR_EACH_VALUE = 68;
    /**
     * <code>FUNC = 69;</code>
     *
     * <pre>
     * An anonymous function.  Takes an array of numbers representing
     * variables (see [VAR] above), and a [Term] to execute with those in
     * scope.  Returns a function that may be passed an array of arguments,
     * then executes the Term with those bound to the variable names.  The
     * user will never construct this directly.  We use it internally for
     * things like `map` which take a function.  The "arity" of a [Function] is
     * the number of arguments it takes.
     * For example, here's what `_X_.map{|x| x+2}` turns into:
     * Term {
     *   type = MAP;
     *   args = [_X_,
     *           Term {
     *             type = Function;
     *             args = [Term {
     *                       type = DATUM;
     *                       datum = Datum {
     *                         type = R_ARRAY;
     *                         r_array = [Datum { type = R_NUM; r_num = 1; }];
     *                       };
     *                     },
     *                     Term {
     *                       type = ADD;
     *                       args = [Term {
     *                                 type = VAR;
     *                                 args = [Term {
     *                                           type = DATUM;
     *                                           datum = Datum { type = R_NUM;
     *                                                           r_num = 1};
     *                                         }];
     *                               },
     *                               Term {
     *                                 type = DATUM;
     *                                 datum = Datum { type = R_NUM; r_num = 2; };
     *                               }];
     *                     }];
     *           }];
     * </pre>
     */
    public static final int FUNC_VALUE = 69;
    /**
     * <code>ASC = 73;</code>
     *
     * <pre>
     * Indicates to ORDER_BY that this attribute is to be sorted in ascending order.
     * </pre>
     */
    public static final int ASC_VALUE = 73;
    /**
     * <code>DESC = 74;</code>
     *
     * <pre>
     * Indicates to ORDER_BY that this attribute is to be sorted in descending order.
     * </pre>
     */
    public static final int DESC_VALUE = 74;
    /**
     * <code>INFO = 79;</code>
     *
     * <pre>
     * Gets info about anything.  INFO is most commonly called on tables.
     * </pre>
     */
    public static final int INFO_VALUE = 79;
    /**
     * <code>MATCH = 97;</code>
     *
     * <pre>
     * `a.match(b)` returns a match object if the string `a`
     * matches the regular expression `b`.
     * </pre>
     */
    public static final int MATCH_VALUE = 97;
    /**
     * <code>UPCASE = 141;</code>
     *
     * <pre>
     * Change the case of a string.
     * </pre>
     */
    public static final int UPCASE_VALUE = 141;
    /**
     * <code>DOWNCASE = 142;</code>
     *
     * <pre>
     * STRING -&gt; STRING
     * </pre>
     */
    public static final int DOWNCASE_VALUE = 142;
    /**
     * <code>SAMPLE = 81;</code>
     *
     * <pre>
     * Select a number of elements from sequence with uniform distribution.
     * </pre>
     */
    public static final int SAMPLE_VALUE = 81;
    /**
     * <code>DEFAULT = 92;</code>
     *
     * <pre>
     * Evaluates its first argument.  If that argument returns
     * NULL or throws an error related to the absence of an
     * expected value (for instance, accessing a non-existent
     * field or adding NULL to an integer), DEFAULT will either
     * return its second argument or execute it if it's a
     * function.  If the second argument is a function, it will be
     * passed either the text of the error or NULL as its
     * argument.
     * </pre>
     */
    public static final int DEFAULT_VALUE = 92;
    /**
     * <code>JSON = 98;</code>
     *
     * <pre>
     * Parses its first argument as a json string and returns it as a
     * datum.
     * </pre>
     */
    public static final int JSON_VALUE = 98;
    /**
     * <code>TO_JSON_STRING = 172;</code>
     *
     * <pre>
     * Returns the datum as a JSON string.
     * N.B.: we would really prefer this be named TO_JSON and that exists as
     * an alias in Python and JavaScript drivers; however it conflicts with the
     * standard `to_json` method defined by Ruby's standard json library.
     * </pre>
     */
    public static final int TO_JSON_STRING_VALUE = 172;
    /**
     * <code>ISO8601 = 99;</code>
     *
     * <pre>
     * Parses its first arguments as an ISO 8601 time and returns it as a
     * datum.
     * </pre>
     */
    public static final int ISO8601_VALUE = 99;
    /**
     * <code>TO_ISO8601 = 100;</code>
     *
     * <pre>
     * Prints a time as an ISO 8601 time.
     * </pre>
     */
    public static final int TO_ISO8601_VALUE = 100;
    /**
     * <code>EPOCH_TIME = 101;</code>
     *
     * <pre>
     * Returns a time given seconds since epoch in UTC.
     * </pre>
     */
    public static final int EPOCH_TIME_VALUE = 101;
    /**
     * <code>TO_EPOCH_TIME = 102;</code>
     *
     * <pre>
     * Returns seconds since epoch in UTC given a time.
     * </pre>
     */
    public static final int TO_EPOCH_TIME_VALUE = 102;
    /**
     * <code>NOW = 103;</code>
     *
     * <pre>
     * The time the query was received by the server.
     * </pre>
     */
    public static final int NOW_VALUE = 103;
    /**
     * <code>IN_TIMEZONE = 104;</code>
     *
     * <pre>
     * Puts a time into an ISO 8601 timezone.
     * </pre>
     */
    public static final int IN_TIMEZONE_VALUE = 104;
    /**
     * <code>DURING = 105;</code>
     *
     * <pre>
     * a.during(b, c) returns whether a is in the range [b, c)
     * </pre>
     */
    public static final int DURING_VALUE = 105;
    /**
     * <code>DATE = 106;</code>
     *
     * <pre>
     * Retrieves the date portion of a time.
     * </pre>
     */
    public static final int DATE_VALUE = 106;
    /**
     * <code>TIME_OF_DAY = 126;</code>
     *
     * <pre>
     * x.time_of_day == x.date - x
     * </pre>
     */
    public static final int TIME_OF_DAY_VALUE = 126;
    /**
     * <code>TIMEZONE = 127;</code>
     *
     * <pre>
     * Returns the timezone of a time.
     * </pre>
     */
    public static final int TIMEZONE_VALUE = 127;
    /**
     * <code>YEAR = 128;</code>
     *
     * <pre>
     * These access the various components of a time.
     * </pre>
     */
    public static final int YEAR_VALUE = 128;
    /**
     * <code>MONTH = 129;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int MONTH_VALUE = 129;
    /**
     * <code>DAY = 130;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int DAY_VALUE = 130;
    /**
     * <code>DAY_OF_WEEK = 131;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int DAY_OF_WEEK_VALUE = 131;
    /**
     * <code>DAY_OF_YEAR = 132;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int DAY_OF_YEAR_VALUE = 132;
    /**
     * <code>HOURS = 133;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int HOURS_VALUE = 133;
    /**
     * <code>MINUTES = 134;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int MINUTES_VALUE = 134;
    /**
     * <code>SECONDS = 135;</code>
     *
     * <pre>
     * PSEUDOTYPE(TIME) -&gt; NUMBER
     * </pre>
     */
    public static final int SECONDS_VALUE = 135;
    /**
     * <code>TIME = 136;</code>
     *
     * <pre>
     * Construct a time from a date and optional timezone or a
     * date+time and optional timezone.
     * </pre>
     */
    public static final int TIME_VALUE = 136;
    /**
     * <code>MONDAY = 107;</code>
     *
     * <pre>
     * Constants for ISO 8601 days of the week.
     * </pre>
     */
    public static final int MONDAY_VALUE = 107;
    /**
     * <code>TUESDAY = 108;</code>
     *
     * <pre>
     * -&gt; 2
     * </pre>
     */
    public static final int TUESDAY_VALUE = 108;
    /**
     * <code>WEDNESDAY = 109;</code>
     *
     * <pre>
     * -&gt; 3
     * </pre>
     */
    public static final int WEDNESDAY_VALUE = 109;
    /**
     * <code>THURSDAY = 110;</code>
     *
     * <pre>
     * -&gt; 4
     * </pre>
     */
    public static final int THURSDAY_VALUE = 110;
    /**
     * <code>FRIDAY = 111;</code>
     *
     * <pre>
     * -&gt; 5
     * </pre>
     */
    public static final int FRIDAY_VALUE = 111;
    /**
     * <code>SATURDAY = 112;</code>
     *
     * <pre>
     * -&gt; 6
     * </pre>
     */
    public static final int SATURDAY_VALUE = 112;
    /**
     * <code>SUNDAY = 113;</code>
     *
     * <pre>
     * -&gt; 7
     * </pre>
     */
    public static final int SUNDAY_VALUE = 113;
    /**
     * <code>JANUARY = 114;</code>
     *
     * <pre>
     * Constants for ISO 8601 months.
     * </pre>
     */
    public static final int JANUARY_VALUE = 114;
    /**
     * <code>FEBRUARY = 115;</code>
     *
     * <pre>
     * -&gt; 2
     * </pre>
     */
    public static final int FEBRUARY_VALUE = 115;
    /**
     * <code>MARCH = 116;</code>
     *
     * <pre>
     * -&gt; 3
     * </pre>
     */
    public static final int MARCH_VALUE = 116;
    /**
     * <code>APRIL = 117;</code>
     *
     * <pre>
     * -&gt; 4
     * </pre>
     */
    public static final int APRIL_VALUE = 117;
    /**
     * <code>MAY = 118;</code>
     *
     * <pre>
     * -&gt; 5
     * </pre>
     */
    public static final int MAY_VALUE = 118;
    /**
     * <code>JUNE = 119;</code>
     *
     * <pre>
     * -&gt; 6
     * </pre>
     */
    public static final int JUNE_VALUE = 119;
    /**
     * <code>JULY = 120;</code>
     *
     * <pre>
     * -&gt; 7
     * </pre>
     */
    public static final int JULY_VALUE = 120;
    /**
     * <code>AUGUST = 121;</code>
     *
     * <pre>
     * -&gt; 8
     * </pre>
     */
    public static final int AUGUST_VALUE = 121;
    /**
     * <code>SEPTEMBER = 122;</code>
     *
     * <pre>
     * -&gt; 9
     * </pre>
     */
    public static final int SEPTEMBER_VALUE = 122;
    /**
     * <code>OCTOBER = 123;</code>
     *
     * <pre>
     * -&gt; 10
     * </pre>
     */
    public static final int OCTOBER_VALUE = 123;
    /**
     * <code>NOVEMBER = 124;</code>
     *
     * <pre>
     * -&gt; 11
     * </pre>
     */
    public static final int NOVEMBER_VALUE = 124;
    /**
     * <code>DECEMBER = 125;</code>
     *
     * <pre>
     * -&gt; 12
     * </pre>
     */
    public static final int DECEMBER_VALUE = 125;
    /**
     * <code>LITERAL = 137;</code>
     *
     * <pre>
     * Indicates to MERGE to replace, or remove in case of an empty literal, the
     * other object rather than merge it.
     * </pre>
     */
    public static final int LITERAL_VALUE = 137;
    /**
     * <code>GROUP = 144;</code>
     *
     * <pre>
     * SEQUENCE, STRING -&gt; GROUPED_SEQUENCE | SEQUENCE, FUNCTION -&gt; GROUPED_SEQUENCE
     * </pre>
     */
    public static final int GROUP_VALUE = 144;
    /**
     * <code>SUM = 145;</code>
     */
    public static final int SUM_VALUE = 145;
    /**
     * <code>AVG = 146;</code>
     */
    public static final int AVG_VALUE = 146;
    /**
     * <code>MIN = 147;</code>
     */
    public static final int MIN_VALUE = 147;
    /**
     * <code>MAX = 148;</code>
     */
    public static final int MAX_VALUE = 148;
    /**
     * <code>SPLIT = 149;</code>
     *
     * <pre>
     * `str.split()` splits on whitespace
     * `str.split(" ")` splits on spaces only
     * `str.split(" ", 5)` splits on spaces with at most 5 results
     * `str.split(nil, 5)` splits on whitespace with at most 5 results
     * </pre>
     */
    public static final int SPLIT_VALUE = 149;
    /**
     * <code>UNGROUP = 150;</code>
     *
     * <pre>
     * GROUPED_DATA -&gt; ARRAY
     * </pre>
     */
    public static final int UNGROUP_VALUE = 150;
    /**
     * <code>RANDOM = 151;</code>
     *
     * <pre>
     * Takes a range of numbers and returns a random number within the range
     * </pre>
     */
    public static final int RANDOM_VALUE = 151;
    /**
     * <code>CHANGES = 152;</code>
     *
     * <pre>
     * TABLE -&gt; STREAM
     * </pre>
     */
    public static final int CHANGES_VALUE = 152;
    /**
     * <code>ARGS = 154;</code>
     *
     * <pre>
     * ARRAY -&gt; SPECIAL (used to splice arguments)
     * </pre>
     */
    public static final int ARGS_VALUE = 154;
    /**
     * <code>BINARY = 155;</code>
     *
     * <pre>
     * BINARY is client-only at the moment, it is not supported on the server
     * </pre>
     */
    public static final int BINARY_VALUE = 155;
    /**
     * <code>GEOJSON = 157;</code>
     *
     * <pre>
     * OBJECT -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int GEOJSON_VALUE = 157;
    /**
     * <code>TO_GEOJSON = 158;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY) -&gt; OBJECT
     * </pre>
     */
    public static final int TO_GEOJSON_VALUE = 158;
    /**
     * <code>POINT = 159;</code>
     *
     * <pre>
     * NUMBER, NUMBER -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int POINT_VALUE = 159;
    /**
     * <code>LINE = 160;</code>
     *
     * <pre>
     * (ARRAY | PSEUDOTYPE(GEOMETRY))... -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int LINE_VALUE = 160;
    /**
     * <code>POLYGON = 161;</code>
     *
     * <pre>
     * (ARRAY | PSEUDOTYPE(GEOMETRY))... -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int POLYGON_VALUE = 161;
    /**
     * <code>DISTANCE = 162;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) {geo_system:STRING, unit:STRING} -&gt; NUMBER
     * </pre>
     */
    public static final int DISTANCE_VALUE = 162;
    /**
     * <code>INTERSECTS = 163;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) -&gt; BOOL
     * </pre>
     */
    public static final int INTERSECTS_VALUE = 163;
    /**
     * <code>INCLUDES = 164;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) -&gt; BOOL
     * </pre>
     */
    public static final int INCLUDES_VALUE = 164;
    /**
     * <code>CIRCLE = 165;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), NUMBER {num_vertices:NUMBER, geo_system:STRING, unit:STRING, fill:BOOL} -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int CIRCLE_VALUE = 165;
    /**
     * <code>GET_INTERSECTING = 166;</code>
     *
     * <pre>
     * TABLE, PSEUDOTYPE(GEOMETRY) {index:!STRING} -&gt; StreamSelection
     * </pre>
     */
    public static final int GET_INTERSECTING_VALUE = 166;
    /**
     * <code>FILL = 167;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY) -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int FILL_VALUE = 167;
    /**
     * <code>GET_NEAREST = 168;</code>
     *
     * <pre>
     * TABLE, PSEUDOTYPE(GEOMETRY) {index:!STRING, max_results:NUM, max_dist:NUM, geo_system:STRING, unit:STRING} -&gt; ARRAY
     * </pre>
     */
    public static final int GET_NEAREST_VALUE = 168;
    /**
     * <code>POLYGON_SUB = 171;</code>
     *
     * <pre>
     * PSEUDOTYPE(GEOMETRY), PSEUDOTYPE(GEOMETRY) -&gt; PSEUDOTYPE(GEOMETRY)
     * </pre>
     */
    public static final int POLYGON_SUB_VALUE = 171;
    /**
     * <code>MINVAL = 180;</code>
     *
     * <pre>
     * Constants for specifying key ranges
     * </pre>
     */
    public static final int MINVAL_VALUE = 180;
    /**
     * <code>MAXVAL = 181;</code>
     */
    public static final int MAXVAL_VALUE = 181;


    public static TermType valueOf(int value) {
        switch (value) {
            case 1: return DATUM;
            case 2: return MAKE_ARRAY;
            case 3: return MAKE_OBJ;
            case 10: return VAR;
            case 11: return JAVASCRIPT;
            case 169: return UUID;
            case 153: return HTTP;
            case 12: return ERROR;
            case 13: return IMPLICIT_VAR;
            case 14: return DB;
            case 15: return TABLE;
            case 16: return GET;
            case 78: return GET_ALL;
            case 17: return EQ;
            case 18: return NE;
            case 19: return LT;
            case 20: return LE;
            case 21: return GT;
            case 22: return GE;
            case 23: return NOT;
            case 24: return ADD;
            case 25: return SUB;
            case 26: return MUL;
            case 27: return DIV;
            case 28: return MOD;
            case 183: return FLOOR;
            case 184: return CEIL;
            case 185: return ROUND;
            case 29: return APPEND;
            case 80: return PREPEND;
            case 95: return DIFFERENCE;
            case 88: return SET_INSERT;
            case 89: return SET_INTERSECTION;
            case 90: return SET_UNION;
            case 91: return SET_DIFFERENCE;
            case 30: return SLICE;
            case 70: return SKIP;
            case 71: return LIMIT;
            case 87: return OFFSETS_OF;
            case 93: return CONTAINS;
            case 31: return GET_FIELD;
            case 94: return KEYS;
            case 186: return VALUES;
            case 143: return OBJECT;
            case 32: return HAS_FIELDS;
            case 96: return WITH_FIELDS;
            case 33: return PLUCK;
            case 34: return WITHOUT;
            case 35: return MERGE;
            case 36: return BETWEEN_DEPRECATED;
            case 182: return BETWEEN;
            case 37: return REDUCE;
            case 38: return MAP;
            case 39: return FILTER;
            case 40: return CONCAT_MAP;
            case 41: return ORDER_BY;
            case 42: return DISTINCT;
            case 43: return COUNT;
            case 86: return IS_EMPTY;
            case 44: return UNION;
            case 45: return NTH;
            case 170: return BRACKET;
            case 48: return INNER_JOIN;
            case 49: return OUTER_JOIN;
            case 50: return EQ_JOIN;
            case 72: return ZIP;
            case 173: return RANGE;
            case 82: return INSERT_AT;
            case 83: return DELETE_AT;
            case 84: return CHANGE_AT;
            case 85: return SPLICE_AT;
            case 51: return COERCE_TO;
            case 52: return TYPE_OF;
            case 53: return UPDATE;
            case 54: return DELETE;
            case 55: return REPLACE;
            case 56: return INSERT;
            case 57: return DB_CREATE;
            case 58: return DB_DROP;
            case 59: return DB_LIST;
            case 60: return TABLE_CREATE;
            case 61: return TABLE_DROP;
            case 62: return TABLE_LIST;
            case 174: return CONFIG;
            case 175: return STATUS;
            case 177: return WAIT;
            case 176: return RECONFIGURE;
            case 179: return REBALANCE;
            case 138: return SYNC;
            case 75: return INDEX_CREATE;
            case 76: return INDEX_DROP;
            case 77: return INDEX_LIST;
            case 139: return INDEX_STATUS;
            case 140: return INDEX_WAIT;
            case 156: return INDEX_RENAME;
            case 64: return FUNCALL;
            case 65: return BRANCH;
            case 66: return OR;
            case 67: return AND;
            case 68: return FOR_EACH;
            case 69: return FUNC;
            case 73: return ASC;
            case 74: return DESC;
            case 79: return INFO;
            case 97: return MATCH;
            case 141: return UPCASE;
            case 142: return DOWNCASE;
            case 81: return SAMPLE;
            case 92: return DEFAULT;
            case 98: return JSON;
            case 172: return TO_JSON_STRING;
            case 99: return ISO8601;
            case 100: return TO_ISO8601;
            case 101: return EPOCH_TIME;
            case 102: return TO_EPOCH_TIME;
            case 103: return NOW;
            case 104: return IN_TIMEZONE;
            case 105: return DURING;
            case 106: return DATE;
            case 126: return TIME_OF_DAY;
            case 127: return TIMEZONE;
            case 128: return YEAR;
            case 129: return MONTH;
            case 130: return DAY;
            case 131: return DAY_OF_WEEK;
            case 132: return DAY_OF_YEAR;
            case 133: return HOURS;
            case 134: return MINUTES;
            case 135: return SECONDS;
            case 136: return TIME;
            case 107: return MONDAY;
            case 108: return TUESDAY;
            case 109: return WEDNESDAY;
            case 110: return THURSDAY;
            case 111: return FRIDAY;
            case 112: return SATURDAY;
            case 113: return SUNDAY;
            case 114: return JANUARY;
            case 115: return FEBRUARY;
            case 116: return MARCH;
            case 117: return APRIL;
            case 118: return MAY;
            case 119: return JUNE;
            case 120: return JULY;
            case 121: return AUGUST;
            case 122: return SEPTEMBER;
            case 123: return OCTOBER;
            case 124: return NOVEMBER;
            case 125: return DECEMBER;
            case 137: return LITERAL;
            case 144: return GROUP;
            case 145: return SUM;
            case 146: return AVG;
            case 147: return MIN;
            case 148: return MAX;
            case 149: return SPLIT;
            case 150: return UNGROUP;
            case 151: return RANDOM;
            case 152: return CHANGES;
            case 154: return ARGS;
            case 155: return BINARY;
            case 157: return GEOJSON;
            case 158: return TO_GEOJSON;
            case 159: return POINT;
            case 160: return LINE;
            case 161: return POLYGON;
            case 162: return DISTANCE;
            case 163: return INTERSECTS;
            case 164: return INCLUDES;
            case 165: return CIRCLE;
            case 166: return GET_INTERSECTING;
            case 167: return FILL;
            case 168: return GET_NEAREST;
            case 171: return POLYGON_SUB;
            case 180: return MINVAL;
            case 181: return MAXVAL;
            default: return null;
        }
    }

    private final int index;
    private final int value;

    TermType(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}

