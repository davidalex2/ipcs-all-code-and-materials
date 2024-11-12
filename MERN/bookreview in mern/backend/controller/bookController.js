const Book = require('../model/bookSchema');

// Create a new book
exports.createBook = async (req, res) => {
    try {
        const { title, author } = req.body;
        const newBook = new Book({ title, author, reviews: [] });
        await newBook.save();
        res.status(201).json(newBook);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

// Get all books
exports.getBooks = async (req, res) => {
    try {
        const books = await Book.find();
        res.json(books);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

// Add a review to a book
exports.addReview = async (req, res) => {
    try {
        const { user, rating, comment } = req.body;
        const book = await Book.findById(req.params.id);
        if (!book) {
            return res.status(404).json({ message: 'Book not found' });
        }
        book.reviews.push({ user, rating, comment });
        await book.save();
        res.status(201).json(book);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};