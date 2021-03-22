# Zettelkasten
The zettelkasten (German: "slip box") is a knowledge management and note-taking method used in research and study.

### How it works?
A zettelkasten consists of many individual notes with ideas and other short pieces of information that are taken down as they occur or are acquired. The notes are numbered hierarchically, so that new notes may be inserted at the appropriate place, and contain metadata to allow the note-taker to associate notes with each other. [https://en.wikipedia.org/wiki/Zettelkasten]

### Principles
- **Atomicity** - put things that belong together in one note and create a exhaustive title
- **Connectivity** - connect note with another one, it will help with fast findings relations between hundreds of other notes
- **Scalability** - adding a new note, always think about how it will be connected with new notes

### Tips
- Don't use categories, use tags instead
- Write notes in a way you understand later
- Do not create a new note, if you can't conect it with any already existed one (only if it not somthing brand new)
- Use information you already added, read and edit your old notes

# Application
In this application can keep notes in zettelkasten style. It has a simple user-friendly interface and you will be able to create, edit, delete and view your notes.

### Installation
- clone or download this repository
- install adopt-opendjdk-13
- sync maven requirements
- create PostgreSQL database named `javadb`
- build and run server with `adopt-openjdk-13.0.2/bin/java`

### Usage
Add new notes with **Add new note** button. Use short and understandable names. Link every new note with any exsisted one.
![add-new-note.png](https://github.com/OlegYariga/zettelkasten/blob/master/screenshots/add--new-note.png?raw=true)

After adding a large number of notes, you will be able to view nodes graph. This graph will help you to find connectivities that you couldn't noticed before.
![diagram-view.png](https://github.com/OlegYariga/zettelkasten/blob/master/screenshots/diagram-view.png?raw=true)

When you will have a large graph of your notes, then you can use a **filter by tag** to select only notes you want to concentrate on.
![filtered-diagram-view.png](https://github.com/OlegYariga/zettelkasten/blob/master/screenshots/filtered-diagram-view.png?raw=true)

You can click on note in diam view to view of edit it. You can also mark note as deleted (**better way is to not delete old notes. Remember that you collect your own database, and every piece of added information is valuable**)
![view-edit-note.png](https://github.com/OlegYariga/zettelkasten/blob/master/screenshots/view-edit-note.png?raw=true)

### More infromation here
- https://zettelkasten.de/posts/overview/
- https://en.wikipedia.org/wiki/Zettelkasten
- https://habr.com/ru/post/508672/
