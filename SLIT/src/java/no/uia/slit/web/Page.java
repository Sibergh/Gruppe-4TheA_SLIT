package no.uia.slit.web;


/**
 * Using an enum rather than strings to refer to pages (views in JSF lingo)
 * eliminates typos in page references.
 *
 * @author even
 */
public enum Page {
    home("/index"),
    teacher("/teacher/index"),
<<<<<<< HEAD
    course,
    modules,
    module,
    delete,
=======
    modules("courses"),
    module("createModule"),
>>>>>>> parent of be203f3... .

    admin("/admin/index"),
    users,
    user
    ;

    String url;

    Page(String url) {
        this.url = url;
    }

    Page() {
        this.url = this.name();
    }

<<<<<<< HEAD
=======
    public String toString() {
        return url;
    }

>>>>>>> parent of be203f3... .
}
