# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# This file is the source Rails uses to define your schema when running `bin/rails
# db:schema:load`. When creating a new database, `bin/rails db:schema:load` tends to
# be faster and is potentially less error prone than running all of your
# migrations from scratch. Old migrations may fail to apply correctly if those
# migrations use external dependencies or application code.
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2022_02_03_081954) do

  create_table "account_login_change_keys", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "key", null: false
    t.string "login", null: false
    t.datetime "deadline", precision: 6, null: false
  end

  create_table "account_password_hashes", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "password_hash", null: false
  end

  create_table "account_password_reset_keys", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "key", null: false
    t.datetime "deadline", precision: 6, null: false
    t.timestamp "email_last_sent", default: -> { "CURRENT_TIMESTAMP" }, null: false
  end

  create_table "account_remember_keys", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "key", null: false
    t.datetime "deadline", precision: 6, null: false
  end

  create_table "account_verification_keys", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "key", null: false
    t.timestamp "requested_at", default: -> { "CURRENT_TIMESTAMP" }, null: false
    t.timestamp "email_last_sent", default: -> { "CURRENT_TIMESTAMP" }, null: false
  end

  create_table "accounts", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "email", null: false
    t.string "status", default: "unverified", null: false
    t.index ["email"], name: "index_accounts_on_email", unique: true
  end

  create_table "measures", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.bigint "patient_id", null: false
    t.integer "hr"
    t.decimal "grades", precision: 10
    t.decimal "minutes", precision: 10
    t.decimal "seconds", precision: 10
    t.integer "steps"
    t.float "accelerometer_X"
    t.float "accelerometer_Y"
    t.float "accelerometer_Z"
    t.float "gyroscope_X"
    t.float "gyroscope_Y"
    t.float "gyroscope_Z"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["patient_id"], name: "index_measures_on_patient_id"
  end

  create_table "patients", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.string "name"
    t.string "surname"
    t.string "username"
    t.string "password_hash"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.text "private_api_key_ciphertext"
    t.string "private_api_key_bidx"
    t.index ["private_api_key_bidx"], name: "index_patients_on_private_api_key_bidx", unique: true
  end

  create_table "posts", charset: "utf8mb4", collation: "utf8mb4_0900_ai_ci", force: :cascade do |t|
    t.bigint "patient_id", null: false
    t.string "title"
    t.text "body"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["patient_id"], name: "index_posts_on_patient_id"
  end

  add_foreign_key "account_login_change_keys", "accounts", column: "id"
  add_foreign_key "account_password_hashes", "accounts", column: "id"
  add_foreign_key "account_password_reset_keys", "accounts", column: "id"
  add_foreign_key "account_remember_keys", "accounts", column: "id"
  add_foreign_key "account_verification_keys", "accounts", column: "id"
  add_foreign_key "measures", "patients"
  add_foreign_key "posts", "patients"
end
