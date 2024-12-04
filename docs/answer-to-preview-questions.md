# Answer to preview questions

## Week2

1.  什么是标识符，什么是关键字，二者有何区别？为何各种程序设计语言都有标识符、关键字，
    各自有何作用？Java和C的标识符定义有何区别？System、null、true、main、String等，
    是关键字吗，为什么？

    > 什么是标识符，什么是关键字，二者有何区别？

    **Identifiers** (标识符) are names to identify a class, variable, function and
    etc.

    **Keywords** (关键字) are reserved words who have predefined meaning.
    Based on their functionality, they are for different purposes.

    > 为何各种程序设计语言都有标识符、关键字，各自有何作用？

    Their functionalities have been figured out as above.

    > Java和C的标识符定义有何区别？

    For Java, identifiers for defining class should begin with an upper case
    letter (aka CamelCase), while others such as used for naming variables are
    conventionally named with a lower case letter (aka camelCase). Note the
    difference that CamelCase has a capitalized letter.

    From a perspective of encoding, Java supports Unicode in variable names,
    where C doesn't.

    > System、null、true、main、String等，是关键字吗，为什么？

    No, they aren't.

    `System` and `String` are identifiers because they are not
    reserved words, from Java class library. `main` is a function, which should
    be defined for running classes, so it's also not keywords.

    `null` and `true` besides `false` (not talked about) are all literals
    (literals are neither identifiers nor keywords) defined in Java, who have
    specific value we cannot change.

1.  C有哪些数据类型，Java有哪些数据类型？C中的struct类型构造机制，对应java何种机制？
    C用int型数据非零、零表示真、假，java如何做的，其做法有何好处？数组属于什么类型，
    java中的数组是如何定义和使用的？

    > C有哪些数据类型，Java有哪些数据类型？

    C: *integral types* including `char`, `short`, `int`, `unsigned`, `long` and
    `long long`; *floating point types* including `float`, `double` and
    `long double`. *Mixed data types* such as *pointers* and *arrays*.

    Java: besides types in C and except pointers, also contains `boolean` and
    `byte` as integral type. Classes
    from Java class library such as `String`.

    > C中的struct类型构造机制，对应java何种机制？

    Maybe classes?

    > C用int型数据非零、零表示真、假，java如何做的，其做法有何好处？

    Java uses boolean. It's more clear and shows purposes.

    > 数组属于什么类型，java中的数组是如何定义和使用的？

    It's a mixed data type. Both `DataType[] x = new DataType[num];` and
    `DataType x[] = new DataType[num]` are ok for defining an array.

    Its usage is the consistent with C.

1.  java的函数定义与C的函数定义要求，有哪些区别？

    - Every function in Java should be contained in a class, but in C it doesn't.
    - Return types can be missed in C functions, but in Java they aren't.
    - Java also has a concept of access modifier.
    - Functions in Java can be overloaded, where in C it can't be.

1.  指针与对象有何关系？为何说Java的引用型，是一种“功能受限的指针”？

    Pointers point to objects (对象).

    References:
    - don't support pointer arithmetics;
    - don't own but share objects;
    - is related to GC machenism. 
 
1.  什么是数据结构？为何需要数据结构？有资料说：与C的struct机制相比，类更适合用来构造数据结构，
    这种说法道理何在？顺序表是如何构造的？

    > 什么是数据结构？为何需要数据结构？

    Data structure (数据结构) is the organization process of data in memory, designed
    for faster and more efficient data access and computations.

    > 有资料说：与C的struct机制相比，类更适合用来构造数据结构，这种说法道理何在？

    Data structure is a set of data and operations on them. In C, structs don't
    own functions (operations) where in Java, they do. So Java's methods in
    structs (classes) fit the model of data structure better.

    > 顺序表是如何构造的？

    What do you mean? This problem is ambiguous.
