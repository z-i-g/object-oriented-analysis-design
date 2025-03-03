package com.zig.ooapsecond.twelfthlesson;

public class General {
    General assignmentAttempt(Object object) {
        if (object instanceof General)
            return (General) object;
        return null;
    }
}

class Any extends General {

    Any assignmentAttempt(General object) {
        if (object instanceof Any)
            return (Any) object;
        return null;
    }
}