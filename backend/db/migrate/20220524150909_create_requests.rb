class CreateRequests < ActiveRecord::Migration[7.0]
  def change
    create_table :requests do |t|
      t.references :user, null: false, foreign_key: true
      t.string :requestable_type, null: false
      t.integer :method, null: false

      t.timestamps
    end
  end
end
