#!/bin/bash

# Variables
DB_NAME="sample_db12"     # Name of the database you want to create
DB_USER="postgres"      # PostgreSQL username
DB_PASS="root"      # PostgreSQL password (use with caution in scripts)
DB_HOST="localhost"     # PostgreSQL host (usually localhost)

# Export password (not recommended for production scripts due to security risks)
export PGPASSWORD="$DB_PASS"

# Create database command
psql -U "$DB_USER" -h "$DB_HOST" -c "CREATE DATABASE $DB_NAME;"

# Check if the command was successful
if [ $? -eq 0 ]; then
    echo "Database '$DB_NAME' created successfully."
else
    echo "Failed to create database '$DB_NAME'."
fi

